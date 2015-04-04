package checkedExceptionExample;

public class ServiceNotAvailableAtTheMomentException extends Exception {

    public ServiceNotAvailableAtTheMomentException(String arg0) {
        super("Server isnt avaible at the moment. May network connections go down,"
                + " firewalls go crazy, routers get restarted, etc");
    }

}
