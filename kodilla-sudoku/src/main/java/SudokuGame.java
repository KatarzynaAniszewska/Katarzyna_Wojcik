import java.util.*;

public class SudokuGame {
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;

    SudokuRow sudokuRow = new SudokuRow();
    SudokuBoard sudokuBoard= new SudokuBoard();
    SudokuElement sudokuElement=new SudokuElement();
    Scanner sc = new Scanner(System.in);

    public void placeValuesOnBoard() {//dlaczego jak tutaj wpiszę argument SudokuBoard sudokuBoard to do metody
        boolean end = false;            // solve (SudokuBoard sudokuBoard przekazuje się nowy obiekt, tablica jest znów pusta
        while (!end) {

            printBoard(sudokuBoard);

            String playerInput = sc.next();

            if (playerInput.equals("sudoku") || playerInput.equals("SUDOKU")) {
                end = true;
            } else {

                int columnNumber = Integer.parseInt(playerInput.substring(0, 1)) - 1;
                int rowNumber = Integer.parseInt(playerInput.substring(1, 2)) - 1;
                int playerValue = Integer.parseInt(playerInput.substring(2, 3));

                if (sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).getValue() < 0) {
                    sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(columnNumber).setValue(playerValue);

                } else System.out.println("Field already has a number");

                // do usunięcia po zakończeniu pisania kodu
                System.out.println(sudokuRow.getSudokuElements());
                System.out.println(columnNumber + " column");
                System.out.println(rowNumber + " row");
                System.out.println(playerValue + " number");
                System.out.println(sudokuBoard.getSudokuRows() + "/n");
                System.out.println(sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().
                        get(columnNumber).getFieldPossibleValues());
                System.out.println(sudokuBoard.getSudokuRows().get(1).getSudokuElements().
                        get(2).getFieldPossibleValues());
            }
        }
    }

    public void solveSudoku() {

        List<Integer> checkProgress = new ArrayList<>();
        checkProgress.add(0, 0);
        boolean end = false;
        int tryCounter = 1;

        while (!end) {
            int totalNumberOfpossibleValues = 0;
            int numberOfEmptyFields = 0;
            for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
                for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                    SudokuElement field = sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(k);

                    if (field.getValue() < 0) {
                        numberOfEmptyFields += 1;
                        //CHECKING ROW
                        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
                            if (sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue() > 0) {
                                if (field.getFieldPossibleValues()
                                        .contains(sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue())) {
                                    field.getFieldPossibleValues().remove(field.getFieldPossibleValues()
                                            .indexOf(sudokuBoard.getSudokuRows().get(n).getSudokuElements().get(i).getValue()));

                                    }
                                }
                            }
                        // CHECKING BOX
                        int boxRowMinIndex = n / 3 * 3;
                        int boxColumnMinIndex = k / 3 * 3;
                        int boxRowMaxIndex = boxRowMinIndex + 2;
                        int boxColumnMaxIndex = boxColumnMinIndex + 2;

                        for (int br = boxRowMinIndex; br <= boxRowMaxIndex; br++) {
                            for (int bc = boxColumnMinIndex; bc <= boxColumnMaxIndex; bc++) {
                                if (sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue() > 0) {
                                    if (field.getFieldPossibleValues()
                                            .contains(sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue())) {
                                        field.getFieldPossibleValues()
                                                .remove(field.getFieldPossibleValues().
                                                        indexOf(sudokuBoard.getSudokuRows().get(br).getSudokuElements().get(bc).getValue()));
                                    }
                                }
                            }
                        }
                        // CHECKING COLUMN
                        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRows()) {
                            if (sudokuRow.getSudokuElements().get(k).getValue() > 0) {
                                if (field.getFieldPossibleValues().contains(sudokuRow.getSudokuElements().get(k).getValue())) {
                                    field.getFieldPossibleValues().remove(field.getFieldPossibleValues().
                                            indexOf(sudokuRow.getSudokuElements().get(k).getValue()));
                                }
                            }
                        }
                        if (field.getFieldPossibleValues().size() == 1) {
                            field.setValue(field.getFieldPossibleValues().get(0));
                            System.out.println(field.getFieldPossibleValues().get(0));
                        }

                        totalNumberOfpossibleValues += field.getFieldPossibleValues().size();
                    }
                }
            }

            tryCounter += 1;
            checkProgress.add(tryCounter - 1, totalNumberOfpossibleValues);
            if (numberOfEmptyFields == 0) {

                System.out.println("SUCSESSSSS");
                end = true;
            } else if ((numberOfEmptyFields > 0) && (checkProgress.get(tryCounter - 1).equals(checkProgress.get(tryCounter - 2)))) {

                System.out.println("waiting for solution");

                solveSudokuWhenMoreThenOneSolution();
            }
            printBoard(sudokuBoard);
            System.out.println(sumOfAllSudokuElements());
        }
    }
    public int sumOfAllSudokuElements() {
        return sudokuBoard.getSudokuRows().stream().
                flatMap(sudokuRow1 -> sudokuRow1.getSudokuElements().stream())
                .map(sudokuElement1 -> sudokuElement1.getValue())
                .reduce(0, (sum, current) -> sum = sum + current);
    }

    public void solveSudokuWhenMoreThenOneSolution() {
        boolean end = false;
        while (!end) {
        ArrayDeque<Backtrack> backtracks = new ArrayDeque<>();
        SudokuBoard clonedSudokuBoard = cloneSudokuBoard();

            backtracks.push(new Backtrack(clonedSudokuBoard));


                Random rand = new Random();
                int randomColumn = rand.nextInt(MAX_INDEX +1);
                int randomRow = rand.nextInt(MAX_INDEX +1);
            SudokuElement field = sudokuBoard.getSudokuRows().get(randomColumn).getSudokuElements().get(randomRow);


            if ((field.getValue() < 0) && (field.getFieldPossibleValues().size() > 0)) {
                int bound = field.getFieldPossibleValues().size();
                int index = rand.nextInt(bound);
                int drawedValue = field.getFieldPossibleValues().get(index);

                field.setValue(drawedValue);

                field.getFieldPossibleValues().remove(field.getFieldPossibleValues().indexOf(drawedValue));

                System.out.println("bound" + bound);
                System.out.println("random" + index);
                System.out.println("drawed" + drawedValue);

                solveSudoku();


            } else if ((field.getValue() < 0)&&(field.getFieldPossibleValues().size() == 0) && (backtracks.size() > 0)) {

               sudokuBoard = backtracks.peek().getSudokuBoard();
               System.out.println("back size" + backtracks.size());
                System.out.println("col "+randomColumn);
                System.out.println("row"+randomRow);
                System.out.println(field.getFieldPossibleValues().size());

            }

        }
    }





            //Backtrack backtrack = backtracks.pop();

            //clonedSudokuBoard.getSudokuRows().get(backtrack.getColumnNumber()).
            //getSudokuElements().get(backtrack.getRowNumber()).setValue(SudokuElement.EMPTY);





    public SudokuBoard cloneSudokuBoard() {
        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return clonedSudokuBoard;
    }



        public void printBoard (SudokuBoard sudokuBoard) {
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

    }






