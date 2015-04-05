package checkedExceptionExample;

public class Program {
    public static void main(String[] args) {
        try {
            useService();
        } catch (ServiceNotAvailableAtTheMomentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void useService() throws ServiceNotAvailableAtTheMomentException {

    }
}