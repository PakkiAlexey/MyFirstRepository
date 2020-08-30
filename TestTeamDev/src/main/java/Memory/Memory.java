package Memory;

public class Memory {
   private final int LENGTH = 65535;
   private int[] memory = new int[LENGTH];
   private int dataPointer;

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

    public int currentCell(){
        return memory[dataPointer];
    }
}
