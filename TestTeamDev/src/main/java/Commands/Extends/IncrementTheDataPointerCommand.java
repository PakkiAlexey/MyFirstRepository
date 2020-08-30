package Commands.Extends;

import Commands.Command;
import Memory.Memory;

public class IncrementTheDataPointerCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.incrementTheDataPointer();
    }
}
