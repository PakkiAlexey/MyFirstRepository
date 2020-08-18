package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class OutputTheByteCommand extends Command {
   BrainFuckOperators brainFuckOperators;

    public OutputTheByteCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.outputTheByte();
    }
}
