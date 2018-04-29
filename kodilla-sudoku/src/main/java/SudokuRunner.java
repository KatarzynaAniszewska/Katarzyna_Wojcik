import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class SudokuRunner {
    public static void main(String[] args) {

        boolean finishedGame = false;
        Scanner scan = new Scanner(System.in);

        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            theGame.playSudoku();
            gameFinished = theGame.resolveSudoku();
        }
    }
}



