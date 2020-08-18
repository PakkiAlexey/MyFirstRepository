package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class DecrementTheByteCommand extends Command {
    BrainFuckOperators brainFuckOperators;

    public DecrementTheByteCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.decrementTheByte();
    }
}
