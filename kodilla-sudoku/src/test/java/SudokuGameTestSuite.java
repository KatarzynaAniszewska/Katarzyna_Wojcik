

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SudokuGameTestSuite {

    @Test
    public void solveSudokuTest() {
        //given

        SudokuRow sudokuRow = new SudokuRow();
        SudokuBoard sudokuBoard= new SudokuBoard();

        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(0).setValue(5);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(1).setValue(3);
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(4).setValue(7);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(0).setValue(6);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(3).setValue(1);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(4).setValue(9);
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().get(5).setValue(5);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(1).setValue(9);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(2).setValue(8);
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().get(7).setValue(6);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(0).setValue(8);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(4).setValue(6);
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().get(8).setValue(3);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).setValue(4);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(3).setValue(8);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(5).setValue(3);
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(8).setValue(1);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(0).setValue(7);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(4).setValue(2);
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().get(8).setValue(6);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(1).setValue(6);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(6).setValue(2);
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).setValue(8);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(3).setValue(4);
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().get(4).setValue(1);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(5).setValue(9);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(8).setValue(5);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(4).setValue(8);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(7).setValue(7);
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(8).setValue(9);

        SudokuGame sudokuGame = new SudokuGame();

        sudokuGame.solveSudoku(sudokuBoard);

       int x = sudokuGame.sumOfAllSudokuElements();

        Assert.assertEquals(405,x);







    }
}