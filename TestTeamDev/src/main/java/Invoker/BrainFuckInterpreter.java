package Invoker;

import Command.Command;

public class BrainFuckInterpreter {
    private Command incrementTheDataPointerCommand;
    private Command decrementTheDataPointerCommand;
    private Command incrementTheByteCommand;
    private Command decrementTheByteCommand;
    private Command outputTheByteCommand;
    private Command cycleCommand;

    private BrainFuckInterpreter() {
    }

    public void incrementTheDataPointer(){
        incrementTheDataPointerCommand.execute();
    }

    public void decrementTheDataPointer(){
        decrementTheDataPointerCommand.execute();
    }

    public void incrementTheByte(){
        incrementTheByteCommand.execute();
    }

    public void decrementTheByte(){
        decrementTheByteCommand.execute();
    }

    public void outputTheByte(){
        outputTheByteCommand.execute();
    }

    public void cycle(){
        cycleCommand.execute();
    }

    public static Builder newBuilder(){
        return new BrainFuckInterpreter().new Builder();
    }


    public class Builder {
        private Builder() {
        }

        public Builder setIncrementTheDataPointer(Command incrementTheDataPointer) {
            BrainFuckInterpreter.this.incrementTheDataPointerCommand = incrementTheDataPointer;

            return this;
        }

        public Builder setDecrementTheDataPointer(Command decrementTheDataPointer) {
            BrainFuckInterpreter.this.decrementTheDataPointerCommand = decrementTheDataPointer;

            return this;
        }

        public Builder setIncrementTheByte(Command incrementTheByte) {
            BrainFuckInterpreter.this.incrementTheByteCommand = incrementTheByte;

            return this;
        }

        public Builder setDecrementTheByte(Command decrementTheByte) {
            BrainFuckInterpreter.this.decrementTheByteCommand = decrementTheByte;

            return this;
        }

        public Builder setOutputTheByte(Command outputTheByte) {
            BrainFuckInterpreter.this.outputTheByteCommand = outputTheByte;

            return this;
        }

        public Builder setCycle(Command cycle) {
            BrainFuckInterpreter.this.cycleCommand = cycle;

            return this;
        }

        public BrainFuckInterpreter build() {

            return BrainFuckInterpreter.this;
        }
    }
}
