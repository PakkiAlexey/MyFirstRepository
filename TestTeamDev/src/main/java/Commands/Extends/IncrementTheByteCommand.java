package Commands.Extends;

import Commands.Command;
import Memory.Memory;

public class IncrementTheByteCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.incrementTheByte();
    }

}
