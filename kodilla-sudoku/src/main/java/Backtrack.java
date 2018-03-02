public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int rowNumber;
    private int columnNumber;
    private int fieldValue;

    public Backtrack(SudokuBoard sudokuBoard, int rowNumber, int columnNumber, int fieldValue) {
        this.sudokuBoard = sudokuBoard;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.fieldValue = fieldValue;
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

    public int getFieldValue() {
        return fieldValue;
    }

    @Override
    public String toString() {
        return "Backtrack{" +
                "sudokuBoard=" + sudokuBoard +
                ", rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                ", value=" + fieldValue +
                '}';
    }
}
