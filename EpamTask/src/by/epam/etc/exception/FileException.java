package by.epam.etc.exception;

public class FileException extends Exception {
    public FileException() {
    }

    public FileException(String s) {
        super(s);

    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(Throwable cause) {
        super(cause);
    }
}

