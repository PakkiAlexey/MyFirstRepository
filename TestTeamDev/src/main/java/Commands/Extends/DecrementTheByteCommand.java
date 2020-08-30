package Commands.Extends;

import Commands.Command;
import Memory.Memory;

public class DecrementTheByteCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.decrementTheByte();
    }
}
