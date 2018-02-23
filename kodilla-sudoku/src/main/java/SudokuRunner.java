public class SudokuRunner {

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuRows();

        SudokuGame sudokuGame = new SudokuGame();

        sudokuGame.placeValuesOnBoard();
        sudokuGame.cloneTest();
        sudokuGame.noCloneTest();
       System.out.println(sudokuBoard.getSudokuRows().get(0).getSudokuElements().size());
       System.out.println(sudokuGame.cloneSudokuBoard().getSudokuRows().get(0).getSudokuElements().size());
        }
    }



