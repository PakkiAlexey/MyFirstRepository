package Commands.Extends;

import Commands.Command;
import Memory.Memory;

public class OutputCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.outputTheByte();
    }

}
