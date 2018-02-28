public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int rowNumber;
    private int columnNumber;
    private int value;

    public Backtrack(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;

    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getValue() {
        return value;
    }
}
