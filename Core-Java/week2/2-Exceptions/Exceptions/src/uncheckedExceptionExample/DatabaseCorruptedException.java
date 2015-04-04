package uncheckedExceptionExample;

public class DatabaseCorruptedException extends RuntimeException {

    public DatabaseCorruptedException(String message) {
        super(message);
    }
}