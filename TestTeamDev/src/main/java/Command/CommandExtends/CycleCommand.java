package Command.CommandExtends;

import Command.Command;
import Receiver.BrainFuckOperators;

public class CycleCommand extends Command {
   BrainFuckOperators brainFuckOperators;

    public CycleCommand(BrainFuckOperators brainFuckOperators) {
        this.brainFuckOperators = brainFuckOperators;
    }

    @Override
    public void execute() {
        brainFuckOperators.cycle();
    }
}
