import java.util.ArrayList;
import java.util.List;

public class SudokuElement implements Cloneable {
    public static int EMPTY = -1;
    private int value;
    private List<Integer>fieldPossibleValues = new ArrayList<>();

    public SudokuElement(){
        this.value=EMPTY;
        for(int n =1;n<=9;n++){
            fieldPossibleValues.add(n);}
            this.fieldPossibleValues=fieldPossibleValues;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getFieldPossibleValues() {
        return fieldPossibleValues;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value=" + value +
                '}';
    }
    public SudokuElement clone() throws CloneNotSupportedException {
        SudokuElement cloned = new SudokuElement();
        List<Integer>clonedFieldPossibleValues= new ArrayList<>();
        for(int i:this.fieldPossibleValues){
            clonedFieldPossibleValues.add(i);
        }
        return cloned;
    }





}

