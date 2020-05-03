package ua.nure.pakki.SummaryTask4.Exceptions;

public class DAOExceptions extends Exception {
    private static final long serialVersionUID = -5790983547500431944L;

    public DAOExceptions() {
        super();
    }

    public DAOExceptions(String message) {
        super(message);
    }

    public DAOExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
