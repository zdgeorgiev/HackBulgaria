package customAnotation;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        MyClass myClass = new MyClass(50);

        System.out.println(Arrays.toString(MyClass.class.getAnnotations()));
        System.out.println(myClass.getClass().getAnnotation(ClassInfo.class));
    }
}