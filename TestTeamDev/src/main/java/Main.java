import Command.Command;
import Command.CommandExtends.*;
import Exceptions.IncorrectInputException;
import Invoker.BrainFuckInterpreter;
import Receiver.BrainFuckOperators;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static BrainFuckInterpreter brainFuckInterpreter;

    public static void main(String[] args) {
        String code = getCode();

        new BrainFuckInterpreter().interpret(code);

    }

    private static String getCode() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the code");

        return in.nextLine();
    }


}

