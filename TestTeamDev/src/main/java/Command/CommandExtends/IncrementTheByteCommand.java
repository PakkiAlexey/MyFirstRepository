package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class IncrementTheByteCommand extends Command {
    BrainFuckOperators brainFuckOperators;

    public IncrementTheByteCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.incrementTheByte();
    }
}
