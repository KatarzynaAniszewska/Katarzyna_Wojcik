import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype {
    List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++)
            sudokuRows.add(new SudokuRow());
        this.sudokuRows = sudokuRows;
    }
    public void addSudokuRow(int position, SudokuRow sudokuRow) {
        sudokuRows.add(position, sudokuRow);
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();
        clonedSudokuBoard.sudokuRows = new ArrayList<>();
        for (SudokuRow sudokuRow : sudokuRows) {
            SudokuRow clonedSudokuRow = new SudokuRow();
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElements()) {
                clonedSudokuRow.getSudokuElements().add(sudokuElement.clone());
            }
            clonedSudokuBoard.getSudokuRows().add(clonedSudokuRow);
        }
        return clonedSudokuBoard;
    }
}







