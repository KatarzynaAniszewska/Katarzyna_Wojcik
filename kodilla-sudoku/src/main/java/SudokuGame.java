import java.util.*;

public class SudokuGame {
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;

    private SudokuRow sudokuRow = new SudokuRow();
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private Scanner sc = new Scanner(System.in);
    private ArrayDeque<Backtrack> backtracks = new ArrayDeque<>();

    public static final String PLACE_SUDOKU_MESSAGE = "Please place values on board or insert \"sudoku\" to see solution";
    public static final String FIELD_HAS_NUMBER = "Field already has a number";
    public static final String SUDOKU_SOLVED ="SUDOKU IS SOLVED";
    public static final String PLAY_AGAING = "Do you want to play again ?";
    public static final String YES_OR_NO = "For Yes press \"y\",for no press\"n\"";



    public void placeValuesOnBoard() {
        boolean end = false;
        while (!end) {
            printBoard();
            System.out.println(PLACE_SUDOKU_MESSAGE);
            String playerInput = sc.next();
            if (playerInput.toUpperCase().equals("SUDOKU")) {
                end = true;
            } else {
                int columnNumber = Integer.parseInt(playerInput.substring(0, 1)) - 1;
                int rowNumber = Integer.parseInt(playerInput.substring(1, 2)) - 1;
                int playerValue = Integer.parseInt(playerInput.substring(2, 3));
                if (sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).getValue() == SudokuElement.EMPTY) {
                    sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).setValue(playerValue);
                } else System.out.println(FIELD_HAS_NUMBER);
            }
        }
    }
    public SudokuElement getField (int row, int column) {
        SudokuElement field = sudokuBoard.getSudokuRows().get(row).getSudokuElements().get(column);
        return field;
    }
    public boolean fieldIsEmpty(int row, int column) {
        return sudokuBoard.getSudokuRows().get(row).getSudokuElements().get(column).getValue() == SudokuElement.EMPTY;
    }
    public void removeValueFromfieldPossibleValues(int row, int column,int fieldRow,int fieldColumn) {
        SudokuElement field = getField(fieldRow,fieldColumn);
        field.getFieldPossibleValues().remove(field.getFieldPossibleValues()
                .indexOf(sudokuBoard.getSudokuRows().get(row).getSudokuElements().get(column).getValue()));
    }
    public boolean ifFieldPossibleValuesContainsValue (int row, int column,int fieldRow,int fieldColumn) {
        return getField(fieldRow,fieldColumn).getFieldPossibleValues().contains(sudokuBoard.getSudokuRows().
                get(row).getSudokuElements().get(column).getValue());
    }
    boolean end = false;
    public void solveSudoku() {
        List<Integer> checkProgress = new ArrayList<>();
        checkProgress.add(0, 0);
        int tryCounter = 1;
        while (!end) {
            int totalNumberOfpossibleValues = 0;
            int numberOfEmptyFields = 0;
            for (int row = MIN_INDEX; row <= MAX_INDEX; row++) {
                for (int column = MIN_INDEX; column <= MAX_INDEX; column++) {
                    SudokuElement field = getField(row,column);
                        if (fieldIsEmpty(row,column)) {
                            numberOfEmptyFields += 1;
                        for (int column2 = MIN_INDEX; column2 <= MAX_INDEX; column2++) {
                            if (!fieldIsEmpty(row,column2)) {
                                if (ifFieldPossibleValuesContainsValue(row,column2,row,column)) {
                                    removeValueFromfieldPossibleValues(row,column2,row,column);
                                }
                            }
                        }
                        int boxRowMinIndex = row / 3 * 3;
                        int boxColumnMinIndex = column / 3 * 3;
                        int boxRowMaxIndex = boxRowMinIndex + 2;
                        int boxColumnMaxIndex = boxColumnMinIndex + 2;
                        for (int br = boxRowMinIndex; br <= boxRowMaxIndex; br++) {
                            for (int bc = boxColumnMinIndex; bc <= boxColumnMaxIndex; bc++) {
                                if (!fieldIsEmpty(br,bc)) {
                                    if (ifFieldPossibleValuesContainsValue(br,bc,row,column)) {
                                        removeValueFromfieldPossibleValues(br,bc,row,column);
                                    }
                                }
                            }
                        }
                            for (int row2 = MIN_INDEX; row2 <= MAX_INDEX; row2++) {
                                if (!fieldIsEmpty(row2,column)) {
                                    if (ifFieldPossibleValuesContainsValue(row2,column,row,column)) {
                                        removeValueFromfieldPossibleValues(row2,column,row,column);
                                    }
                                }
                            }
                        if (field.getFieldPossibleValues().size() == 1) {
                            field.setValue(field.getFieldPossibleValues().get(0));
                        }
                        totalNumberOfpossibleValues += field.getFieldPossibleValues().size();
                    }
                }
            }
            tryCounter += 1;
            checkProgress.add(tryCounter - 1, totalNumberOfpossibleValues);
            if (numberOfEmptyFields == 0) {
                System.out.println(SUDOKU_SOLVED);
                printBoard();
                end = true;
            } else if ((numberOfEmptyFields > 0) && (checkProgress.get(tryCounter - 1)
                    .equals(checkProgress.get(tryCounter - 2)))) {
                solveSudokuWhenMoreThenOneSolution();
            }
        }
    }
    public void solveSudokuWhenMoreThenOneSolution() {
        while (!end) {
            List<int[]> emptyFields = new ArrayList<>();
            for (int row = 0; row <= MAX_INDEX; row++) {
                for (int column = 0; column <= MAX_INDEX; column++) {
                    SudokuElement field = getField(row,column);
                    if (fieldIsEmpty(row,column))
                            //(field.getValue() == SudokuElement.EMPTY)
                        {
                        int[] rowAndColumn = {row, column};
                        emptyFields.add(rowAndColumn);
                    }
                }
            }
            if (emptyFields.size() > 0) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(emptyFields.size());
                int randomRowIndeks = emptyFields.get(randomIndex)[0];
                int randomColumnIndeks = emptyFields.get(randomIndex)[1];
                SudokuElement emptyfield = getField(randomRowIndeks,randomColumnIndeks);
                if (emptyfield.getFieldPossibleValues().size() > 0) {
                    SudokuBoard clonedSudokuBoard = cloneSudokuBoard();
                    int randomIndexForFieldValue = rand.nextInt(emptyfield.getFieldPossibleValues().size());
                    int randomFieldValue = emptyfield.getFieldPossibleValues().get(randomIndexForFieldValue);
                    emptyfield.setValue(randomFieldValue);
                    backtracks.push(new Backtrack(clonedSudokuBoard, randomColumnIndeks, randomRowIndeks, randomFieldValue));
                    solveSudoku();
                } else if (emptyfield.getFieldPossibleValues().size() == 0) {
                    Backtrack backtrack = backtracks.pollFirst();
                    sudokuBoard = backtrack.getSudokuBoard();
                    int valueIndex = sudokuBoard.getSudokuRows().get(backtrack.getRandomRowIndex()).getSudokuElements()
                            .get(backtrack.getRandomColumnIndex()).getFieldPossibleValues().indexOf(backtrack.getRandomValue());
                    sudokuBoard.getSudokuRows().get(backtrack.getRandomRowIndex()).getSudokuElements()
                            .get(backtrack.getRandomColumnIndex()).getFieldPossibleValues().remove(valueIndex);
                }
            } else end = true;
        }
    }
    public SudokuBoard cloneSudokuBoard() {
        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return clonedSudokuBoard;
    }
    public void printBoard() {
        String result = "";
        for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
            if (k == 0) {
                result += "----------------------";
                result += "\n";
            }
            result += "|";
            for (int m = MIN_INDEX; m <= MAX_INDEX; m++) {
                if (sudokuBoard.getSudokuRows().get(k).getSudokuElements().get(m).getValue() > 0) {
                    result += sudokuBoard.getSudokuRows().get(k).getSudokuElements().get(m).getValue() + " ";
                } else result += "  ";
                if (((m + 1) % 3 == 0) && (m > 0)) {
                    result += "|";
                }
            }
            result += "\n";
            if (k == 2 || k == 5 || k == 8) {
                result += "----------------------" + "\n";
            }
        }
        System.out.println(result);
    }

    public boolean resolveSudoku() {
        System.out.println(PLAY_AGAING);
        System.out.println(YES_OR_NO);
        String answear = sc.next();
        if (answear.toUpperCase().equals("N")) {
            return true;
        }
        return false;
    }
    public void playSudoku(){
        placeValuesOnBoard();
        solveSudoku();
    }
}






