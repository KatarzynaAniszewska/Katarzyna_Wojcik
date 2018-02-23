

import org.junit.Test;

import java.util.List;

public class SudokuGameTestSuite {

    @Test
    public void solveSudokuTest() {
        //given

        SudokuRow sudokuRow = new SudokuRow();
        SudokuBoard sudokuBoard= new SudokuBoard();

        sudokuBoard.getSudokuRows().get(0).getSudokuElements().add(0,new SudokuElement(5));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().add(1,new SudokuElement(6));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().add(3,new SudokuElement(8));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().add(4,new SudokuElement(4));
        sudokuBoard.getSudokuRows().get(0).getSudokuElements().add(5,new SudokuElement(7));
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().add(0,new SudokuElement(3));
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().add(2,new SudokuElement(9));
        sudokuBoard.getSudokuRows().get(1).getSudokuElements().add(6,new SudokuElement(6));
        sudokuBoard.getSudokuRows().get(2).getSudokuElements().add(2,new SudokuElement(8));
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().add(1,new SudokuElement(1));
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().add(5,new SudokuElement(8));
        sudokuBoard.getSudokuRows().get(3).getSudokuElements().add(7,new SudokuElement(4));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(0,new SudokuElement(7));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(1,new SudokuElement(9));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(3,new SudokuElement(6));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(5,new SudokuElement(2));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(7,new SudokuElement(1));
        sudokuBoard.getSudokuRows().get(4).getSudokuElements().add(8,new SudokuElement(8));
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().add(1,new SudokuElement(5));
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().add(3,new SudokuElement(3));
        sudokuBoard.getSudokuRows().get(5).getSudokuElements().add(5,new SudokuElement(9));
        sudokuBoard.getSudokuRows().get(6).getSudokuElements().add(6,new SudokuElement(2));
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().add(2,new SudokuElement(6));
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().add(6,new SudokuElement(8));
        sudokuBoard.getSudokuRows().get(7).getSudokuElements().add(8,new SudokuElement(7));
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().add(3,new SudokuElement(3));
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().add(4,new SudokuElement(1));
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().add(5,new SudokuElement(6));
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().add(7,new SudokuElement(5));
        sudokuBoard.getSudokuRows().get(8).getSudokuElements().add(8,new SudokuElement(9));

        SudokuGame sudokuGame = new SudokuGame();

        List<SudokuRow> sudoku = sudokuGame.placeValuesOnBoard();
        sudoku = sudokuBoard.getSudokuRows();
        sudokuGame.printBoard();







    }
}