package junitImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        JUnit j = new JUnit();

        HashSet<Method> beforeMethods = new HashSet<Method>();
        HashSet<Method> afterMethods = new HashSet<Method>();
        HashSet<Method> executable = new HashSet<Method>();

        Method[] allMethods = j.getClass().getMethods();

        for (Method m : allMethods) {

            if (m.isAnnotationPresent(Before.class)) {
                beforeMethods.add(m);
            } else if (m.isAnnotationPresent(After.class)) {
                afterMethods.add(m);
            } else if (m.isAnnotationPresent(Execute.class)) {
                executable.add(m);
            }
        }

        for (Method eMethod : executable) {
            try {

                // Execute all before methods
                for (Method bMethod : beforeMethods) {
                    Class<?>[] bParams = bMethod.getParameterTypes();
                    bMethod.invoke(j, bParams);
                }

                // Execute the main method
                Class<?>[] eParams = eMethod.getParameterTypes();
                eMethod.invoke(j, eParams);

                // Execute all after methods
                for (Method aMethod : afterMethods) {
                    Class<?>[] aParams = aMethod.getParameterTypes();
                    aMethod.invoke(j, aParams);
                }

            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
