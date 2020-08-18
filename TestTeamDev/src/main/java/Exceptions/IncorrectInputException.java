package Exceptions;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String errorMassage){
        super(errorMassage);
    }
}
