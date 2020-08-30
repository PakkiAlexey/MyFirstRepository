package Compiler;

import Commands.Command;
import Commands.Extends.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BrainFuckCompiler {
    private BrainFuckCompiler.CommandContainer commandContainer;
    {
        commandContainer = new CommandContainer();
    }

    public List<Command> compile(String code) {
        return getInnerCommands(code);

    }

    private List<Command> getInnerCommands(String currentPartOfCode) {
        List<Command> listOfInnerCommands = new LinkedList<>();

        for (int i = 0; i < currentPartOfCode.length(); i++) {
            if (currentPartOfCode.charAt(i) != '[') {
                listOfInnerCommands.add(commandContainer.get(currentPartOfCode.charAt(i)));

            } else {
                int indexOfEndingOfCycle = getPositionOfClosedBracket(i + 1,currentPartOfCode.substring(i + 1));
                Command cycleCommand = new CycleCommand(getInnerCommands(currentPartOfCode.substring(i + 1, indexOfEndingOfCycle)));

                listOfInnerCommands.add(cycleCommand);
                i = indexOfEndingOfCycle;
            }
        }

        return listOfInnerCommands;
    }

    private int getPositionOfClosedBracket(int start, String currentPartOfCode) {
        int count = 1;
        int i = 0;

        while (count > 0) {
            if (currentPartOfCode.charAt(i) == '[') {
                count++;
            }

            if (currentPartOfCode.charAt(i) == ']') {
                count--;
            }
            i++;
        }

        return i + start - 1;
    }

    static class CommandContainer {
        private Map<Character, Command> commands;

        {
            commands = new HashMap<>();

            commands.put('>', new IncrementTheDataPointerCommand());
            commands.put('<', new DecrementTheDataPointerCommand());
            commands.put('+', new IncrementTheByteCommand());
            commands.put('-', new DecrementTheByteCommand());
            commands.put('.', new OutputCommand());

        }

        public Command get(Character commandName) {
            return commands.get(commandName);
        }
    }
}
