import Solver.Board;
import Utils.ColorPrint;

import java.util.ArrayList;
import java.util.Arrays;

import static Utils.ColorPrint.*;
//import static Utils.Arrows.*;

public class Npuzzle {
    //todo стратегия, меню, конечная карта (ответ), дописать проверку на неправильный ввод, начать A*
    public static void main(String[] args) {
        int[][] y = Validator.validation("test.txt");
        for (int[] i : y) {
            ColorPrint.print(BLUE, i, true);
//            System.out.println(Arrays.toString(i));
        }
//        Arrays.stream(y).forEach(System.out::println);
//        for (String s : args) {
//            System.out.println(s);
//        }
//        print(RESET, "Hello, Pieter", true);
//        print(BLACK, "Hello, Pieter", true);
//        print(GREEN, "Hello, Pieter", false);
//        print(RED, "Hello, Pieter", false);
//        print(YELLOW, "Hello, Pieter", false);
//        print(BLUE, "Hello, Pieter", false);
//        print(PURPLE, "Hello, Pieter", false);
//        print(CYAN, "Hello, Pieter", true);
//        print(WHITE, "Hello, Pieter", true);
//        print(YELLOW, RIGHT, true);
//        print(YELLOW, LEFT, true);
//        print(YELLOW, UP, true);
//        print(YELLOW, DOWN, true);
//
//        int[][] arr = {{42, 45, 25, 16,  2, 11, 39},
//                {24, 35, 27, 30, 36, 41, 44},
//                {33, 20,  3, 26, 10, 18,  7},
//                {1, 22, 29, 43, 21, 19,  9},
//                {28, 34, 37,  4,  8,  5, 31},
//                {17, 32, 40, 46, 47,  0,  6},
//                {15, 14, 48, 23, 12, 13, 38}
//        };
//
//        Board board = new Board(arr);

    }


}
