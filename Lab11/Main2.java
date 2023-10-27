package Lab11;

import java.util.Arrays;
import java.util.List;

import Lab11.code.Puzzle8_651328;
import Lab11.code.Puzzle8State;

public class Main2 {
    public static void main(String[] args) {
        demo3();
    }

    static void demo1(){
        Puzzle8_651328 game = new Puzzle8_651328(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.displayBoard();
    }

    static void demo2(){
        Puzzle8_651328 game = new Puzzle8_651328(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.generateNextMove();
    }

    static void demo3(){
        Puzzle8_651328 game = new Puzzle8_651328(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.nextMoveWithStack();
        System.out.println(game.explored.size());
        System.out.println("partial explored state");
        for (Puzzle8State s : game.explored) {
            if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4)
                System.out.println(Arrays.toString(s.sequence));
        }
        System.out.println("note that program terminates prior to pushing goal state into explored!!");
    }
}
