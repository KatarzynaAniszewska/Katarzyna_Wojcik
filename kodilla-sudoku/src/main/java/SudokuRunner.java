public class SudokuRunner {

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows();

        SudokuGame sudokuGame = new SudokuGame();

       sudokuGame.placeValuesOnBoard();
   // sudokuGame.solveSudoku();
sudokuGame.solveSudokuWhenMoreThenOneSolution();

        }
    }



