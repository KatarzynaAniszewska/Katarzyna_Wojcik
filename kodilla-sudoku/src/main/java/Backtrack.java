public class Backtrack {

    private SudokuBoard sudokuBoard;
    private int randomRowIndex;
    private int randomColumnIndex;
    private int randomValue;

    public Backtrack(SudokuBoard sudokuBoard, int randomRowIndex, int randomColumnIndex, int randomValue) {
        this.sudokuBoard = sudokuBoard;
        this.randomRowIndex = randomRowIndex;
        this.randomColumnIndex = randomColumnIndex;
        this.randomValue = randomValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRandomRowIndex() {
        return randomRowIndex;
    }

    public int getRandomColumnIndex() {
        return randomColumnIndex;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
