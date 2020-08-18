package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class IncrementTheDataPointerCommand extends Command {
    BrainFuckOperators brainFuckOperators;

    public IncrementTheDataPointerCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.incrementTheDataPointer();
    }
}
