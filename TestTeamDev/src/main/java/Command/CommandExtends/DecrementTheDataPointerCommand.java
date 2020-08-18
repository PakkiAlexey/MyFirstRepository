package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class DecrementTheDataPointerCommand extends Command {
    BrainFuckOperators brainFuckOperators;

    public DecrementTheDataPointerCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.decrementTheDataPointer();
    }
}
