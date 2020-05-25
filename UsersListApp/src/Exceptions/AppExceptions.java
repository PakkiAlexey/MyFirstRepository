package Exceptions;

public class AppExceptions extends Exception {
    private static final long serialVersionUID = 4061060965275172050L;;

    public AppExceptions() {
        super();
    }

    public AppExceptions(String message) {
        super(message);
    }

    public AppExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
