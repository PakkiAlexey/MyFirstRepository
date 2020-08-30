package Commands.Extends;

import Commands.Command;
import Memory.Memory;

public class DecrementTheDataPointerCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.decrementTheDataPointer();
    }

    @Override
    public String toString() {
        return "<";
    }
}
