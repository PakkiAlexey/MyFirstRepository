package BrainFuckCode;

public class BrainFuckCode {
    private String sequenceOfCommands;

    public BrainFuckCode(String sequenceOfCommands){
        this.sequenceOfCommands = sequenceOfCommands;
    }

    public Character getTheBrainFuckCommand(int i){
        return sequenceOfCommands.charAt(i);
    }

    public int getLengthOfSequenceOfCommands(){
        return sequenceOfCommands.length();
    }
}
