package Commands;

import Memory.Memory;

public abstract class Command {
    public abstract void execute(Memory memory);
}
