package Receiver;

import Exceptions.IncorrectInputException;

//Receiver

public class BrainFuckOperators {
    private int indexOfOpenedBracket = -1;
    private int currentPosition;
    private int LENGTH = 65535;
    private int[] memory = new int[LENGTH];
    private int dataPointer;
    private String sequenceOfCommands;


    public BrainFuckOperators(String sequenceOfCommands) {
        this.sequenceOfCommands = sequenceOfCommands;
    }

    public void incrementTheDataPointer() {
        if (dataPointer == (LENGTH - 1)) {
            dataPointer = 0;
        } else {
            dataPointer++;
        }
    }

    public void decrementTheDataPointer() {
        if (dataPointer == 0) {
            dataPointer = LENGTH - 1;
        } else {
            dataPointer--;
        }
    }

    public void incrementTheByte() {
        memory[dataPointer]++;
    }

    public void decrementTheByte() {
        memory[dataPointer]--;
    }

    public void outputTheByte() {
        System.out.print((char) memory[dataPointer]);
    }

    public void cycle() {
        int count = 0;

        if (sequenceOfCommands.charAt(currentPosition) == '[') {
            indexOfOpenedBracket = currentPosition;

            if (memory[dataPointer] == 0) {
                currentPosition++;

                while (count > 0 || sequenceOfCommands.charAt(currentPosition) != ']') {
                    if (sequenceOfCommands.charAt(currentPosition) == '[') {
                        count++;
                    }else if (sequenceOfCommands.charAt(currentPosition) == ']') {
                        count--;
                    }
                    currentPosition++;
                }
            } else {
                return;
            }
        }

        if (sequenceOfCommands.charAt(currentPosition) == ']'){
            if (indexOfOpenedBracket < 0){
                throw new IncorrectInputException("Incorrect sequence of brackets");

            }

            if (memory[dataPointer] != 0){
                currentPosition--;

                while (count > 0 || sequenceOfCommands.charAt(currentPosition) != '['){
                    if (sequenceOfCommands.charAt(currentPosition) == ']') {
                        count++;
                    }if (sequenceOfCommands.charAt(currentPosition) == '[') {
                        count--;
                    }
                    currentPosition--;
                }
                currentPosition--;
            } else {
                return;
            }
        }
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getSequenceOfCommands() {
        return sequenceOfCommands;
    }
}
