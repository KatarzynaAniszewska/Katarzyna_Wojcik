import java.util.*;

public class SudokuGame {
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;


    SudokuRow sudokuRow = new SudokuRow();
    SudokuBoard sudokuBoard = new SudokuBoard();
    Scanner sc = new Scanner(System.in);
    ArrayDeque<Backtrack> backtracks = new ArrayDeque<>();

    public void placeValuesOnBoard() {
        boolean end = false;
        while (!end) {

            printBoard();
            System.out.println("Please place values on board or insert \"sudoku\" to see solution");

            String playerInput = sc.next();

            if (playerInput.toUpperCase().equals("SUDOKU")) {
                end = true;
            } else {

                int columnNumber = Integer.parseInt(playerInput.substring(0, 1)) - 1;
                int rowNumber = Integer.parseInt(playerInput.substring(1, 2)) - 1;
                int playerValue = Integer.parseInt(playerInput.substring(2, 3));

                if (sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).getValue() == SudokuElement.EMPTY) {
                    sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).setValue(playerValue);

                } else System.out.println("Field already has a number");
            }
        }
    }

    boolean end = false;

    public void solveSudoku() {

        List<Integer> checkProgress = new ArrayList<>();
        checkProgress.add(0, 0);
        int tryCounter = 1;


        while (!end) {
            int totalNumberOfpossibleValues = 0;
            int numberOfEmptyFields = 0;
            for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
                for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                    SudokuElement field = sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(k);

                    if (field.getValue() == SudokuElement.EMPTY) {
                        numberOfEmptyFields += 1;

                        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
                            if (sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue() != SudokuElement.EMPTY) {
                                if (field.getFieldPossibleValues()
                                        .contains(sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue())) {
                                    field.getFieldPossibleValues().remove(field.getFieldPossibleValues()
                                            .indexOf(sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue()));

                                }
                            }
                        }
                        int boxRowMinIndex = n / 3 * 3;
                        int boxColumnMinIndex = k / 3 * 3;
                        int boxRowMaxIndex = boxRowMinIndex + 2;
                        int boxColumnMaxIndex = boxColumnMinIndex + 2;

                        for (int br = boxRowMinIndex; br <= boxRowMaxIndex; br++) {
                            for (int bc = boxColumnMinIndex; bc <= boxColumnMaxIndex; bc++) {
                                if (sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue() != SudokuElement.EMPTY) {
                                    if (field.getFieldPossibleValues()
                                            .contains(sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue())) {
                                        field.getFieldPossibleValues()
                                                .remove(field.getFieldPossibleValues().
                                                        indexOf(sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue()));
                                    }
                                }
                            }
                        }
                        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRows()) {
                            if (sudokuRow.getSudokuElements().get(k).getValue() != SudokuElement.EMPTY) {
                                if (field.getFieldPossibleValues().contains(sudokuRow.getSudokuElements().get(k).getValue())) {
                                    field.getFieldPossibleValues().remove(field.getFieldPossibleValues().
                                            indexOf(sudokuRow.getSudokuElements().get(k).getValue()));
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

                System.out.println("SUDOKU IS SOLVED");
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
            for (int a = 0; a <= MAX_INDEX; a++) {
                for (int b = 0; b <= MAX_INDEX; b++) {
                    SudokuElement field = sudokuBoard.getSudokuRows().get(a).getSudokuElements().get(b);

                    if (field.getValue() == SudokuElement.EMPTY) {
                        int[] rowAndColumn = {a, b};
                        emptyFields.add(rowAndColumn);
                    }
                }
            }
            if (emptyFields.size() > 0) {
                //losuje z pustych pól
                Random rand = new Random();
                int randomIndex = rand.nextInt(emptyFields.size());
                int randomRowIndeks = emptyFields.get(randomIndex)[0];
                int randomColumnIndeks = emptyFields.get(randomIndex)[1];

                SudokuElement emptyfield = sudokuBoard.getSudokuRows().get(randomRowIndeks).sudokuElements.get(randomColumnIndeks);

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

        System.out.println("Do you want to play again ?");
        System.out.println("For Yes press \"y\",for no press\"n\"");
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






