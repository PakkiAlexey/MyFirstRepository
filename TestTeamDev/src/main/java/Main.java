import Commands.Command;
import Compiler.BrainFuckCompiler;
import Memory.Memory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String code = getCode();

        List<Command> commandList = new BrainFuckCompiler().compile(code);

        Memory memory = new Memory();

        for (Command command : commandList) {
            command.execute(memory);
        }
    }

    private static String getCode(){
        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }
}
