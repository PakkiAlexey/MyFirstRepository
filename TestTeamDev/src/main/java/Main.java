import Commands.Command;
import Compiler.BrainFuckCompiler;
import Memory.Memory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input code");
        String code = in.nextLine();

        BrainFuckCompiler brainFuckCompiler = new BrainFuckCompiler();
        List<Command> commandList = brainFuckCompiler.compile(code);

        Memory memory = new Memory();

        for (Command command : commandList) {
            command.execute(memory);
        }

    }
}
