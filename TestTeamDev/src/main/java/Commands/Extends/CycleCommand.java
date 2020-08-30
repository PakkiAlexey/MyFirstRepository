package Commands.Extends;

import Commands.Command;
import Memory.Memory;

import java.util.List;

public class CycleCommand extends Command {
    private List<Command> innerCommands;

    public CycleCommand(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    @Override
    public void execute(Memory memory) {
        while (memory.currentCell() > 0) {
            for (Command command : innerCommands) {
                command.execute(memory);
            }
        }
    }

}
