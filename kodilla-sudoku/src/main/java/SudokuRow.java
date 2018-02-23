import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    List<SudokuElement> sudokuElements=new ArrayList<>();

    public SudokuRow() {
        for (int j = 0; j < 9; j++)
            sudokuElements.add(new SudokuElement());
            this.sudokuElements=sudokuElements;
        }


    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    public void addSudokuElement(int position,SudokuElement sudokuElement){
        sudokuElements.add(position,sudokuElement);
    }

    @Override
    public String toString() {
        return "SudokuRow{" +
                "sudokuElements=" + sudokuElements +
                '}';
    }
}

