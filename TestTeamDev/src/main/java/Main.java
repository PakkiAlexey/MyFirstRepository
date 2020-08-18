import Command.CommandExtends.*;
import Exceptions.IncorrectInputException;
import Invoker.BrainFuckInterpreter;
import Receiver.BrainFuckOperators;

import java.util.Scanner;

public class Main {
    private static BrainFuckOperators brainFuckOperators;
    private static BrainFuckInterpreter brainFuckInterpreter;

    public static void main(String[] args) {
        String code = getCode();
        initializationOfModel(code);
        interpret();

    }

    private static String getCode() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the code");

        return in.nextLine();
    }

    private static void initializationOfModel(String code) {
        brainFuckOperators = new BrainFuckOperators(code);

        brainFuckInterpreter = BrainFuckInterpreter.newBuilder()
                .setIncrementTheDataPointer(new IncrementTheDataPointerCommand(brainFuckOperators))
                .setDecrementTheDataPointer(new DecrementTheDataPointerCommand(brainFuckOperators))
                .setIncrementTheByte(new IncrementTheByteCommand(brainFuckOperators))
                .setDecrementTheByte(new DecrementTheByteCommand(brainFuckOperators))
                .setOutputTheByte(new OutputTheByteCommand(brainFuckOperators))
                .setCycle(new CycleCommand(brainFuckOperators))
                .build();
    }

    private static void interpret() {
        String code = brainFuckOperators.getSequenceOfCommands();

        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '>': {
                    brainFuckInterpreter.incrementTheDataPointer();
                    break;
                }

                case '<': {
                    brainFuckInterpreter.decrementTheDataPointer();
                    break;
                }

                case '+': {
                    brainFuckInterpreter.incrementTheByte();
                    break;
                }

                case '-': {
                    brainFuckInterpreter.decrementTheByte();
                    break;
                }

                case '.': {
                    brainFuckInterpreter.outputTheByte();
                    break;
                }

                case '[':
                case ']': {
                    brainFuckOperators.setCurrentPosition(i);
                    brainFuckInterpreter.cycle();
                    i = brainFuckOperators.getCurrentPosition();
                    break;
                }

                case ',': {
                    break;
                }

                default: {
                    throw new IncorrectInputException("There is no such command in brainfuck language: " + code.charAt(i));
                }
            }
        }
    }
}
