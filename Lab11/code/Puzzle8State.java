package Lab11.code;

import java.util.Arrays;

public class Puzzle8State {
    public int[] sequence;
    public int score;

    public Puzzle8State(int[] sequence) {
        this.sequence = sequence;
    }

    public Puzzle8State() {}

    public boolean equals(Puzzle8State other) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != other.sequence[i])
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < sequence.length; i++) {
            s += sequence[i] + " ";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Puzzle8State otherState = (Puzzle8State) obj;
        return Arrays.equals(sequence, otherState.sequence);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sequence);
    }

    public void displayBoard(){
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                System.out.print("  ");
            } else {
                System.out.print(sequence[i] + " ");
            }
            if (i % 3 == 2) {
                System.out.println();
            }
        }
    }
}
