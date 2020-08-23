package Invoker;


import BrainFuckCode.BrainFuckCode;
import Command.Command;
import Command.CommandExtends.*;
import Receiver.BrainFuckOperators;

import java.util.HashMap;
import java.util.Map;


public class BrainFuckInterpreter {
    private BrainFuckOperators brainFuckOperators;

    public void interpret(String code) {

        brainFuckOperators = new BrainFuckOperators(code);
        BrainFuckCode sequenceOFCommands = new BrainFuckCode(code);

        BrainFuckInterpreter.CommandContainer commandContainer = new CommandContainer();

        for (int i = 0; i < sequenceOFCommands.getLengthOfSequenceOfCommands(); i++) {
            if ((sequenceOFCommands.getTheBrainFuckCommand(i) == '[') || sequenceOFCommands.getTheBrainFuckCommand(i) == ']') {
                brainFuckOperators.setCurrentPosition(i);
                commandContainer.get(sequenceOFCommands.getTheBrainFuckCommand(i)).execute();
                i = brainFuckOperators.getCurrentPosition();

                continue;
            }

            commandContainer.get(sequenceOFCommands.getTheBrainFuckCommand(i)).execute();
        }

    }

    class CommandContainer {
        private Map<Character, Command> commands = new HashMap<>();

        {
            commands.put('>', new IncrementTheDataPointerCommand(brainFuckOperators));
            commands.put('<', new DecrementTheDataPointerCommand(brainFuckOperators));
            commands.put('+', new IncrementTheByteCommand(brainFuckOperators));
            commands.put('-', new DecrementTheByteCommand(brainFuckOperators));
            commands.put('.', new OutputTheByteCommand(brainFuckOperators));
            commands.put('[', new CycleCommand(brainFuckOperators));
            commands.put(']', new CycleCommand(brainFuckOperators));
        }

        public Command get(Character commandName) {
            return commands.get(commandName);
        }
    }
}
