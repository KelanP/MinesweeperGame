import java.util.Scanner;

public class Board {
    private static int rows;
    private static int columns;
    private static int mines;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    Tile[][] tileArray = new Tile[rows][columns]; //instantiate an array of tiles

    //initialise the board
    public void initialiseTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tileArray[i][j] = new Tile(i, j, "0", "?", true, false, false); //assigns each tile its relative position and sets it hidden

            }
        }

        for (int x = mines; x > 0; x--) {
            int randomRow = (int) (Math.random() * (rows - 1));
            int randomColumn = (int) (Math.random() * (columns - 1));

            tileArray[randomRow][randomColumn].setMine(true);
            tileArray[randomRow][randomColumn].mineIcon(); //sets mine value to a bomb  icon
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tileArray[i][j].isMine() == false) {
                    int count = 0;
                    int row = tileArray[i][j].getPositionRow();
                    int col = tileArray[i][j].getPositionColumn();
                    //top left
                    if ((row - 1) >= 0 && (col - 1) >= 0) {
                        if (tileArray[row - 1][col - 1].isMine() == true) {
                            count = +1;
                        }
                    }
                    //above
                    if (row - 1 >= 0) {
                        if (tileArray[row - 1][col].isMine() == true) {
                            count += 1;
                        }
                    }
                    //top right
                    if ((row - 1) >= 0 && (col + 1) <= columns - 1) {
                        if (tileArray[row - 1][col + 1].isMine() == true) {
                            count += 1;
                        }
                    }
                    //left
                    if ((col - 1) >= 0) {
                        if (tileArray[row][col - 1].isMine() == true) {
                            count += 1;
                        }
                    }
                    //right
                    if ((col + 1) <= columns - 1) {
                        if (tileArray[row][col + 1].isMine() == true) {
                            count += 1;
                        }
                    }
                    //bottom left
                    if ((row + 1) <= rows - 1 && (col - 1) >= 0) {
                        if (tileArray[row + 1][col - 1].isMine() == true)
                            count += 1;
                    }
                    //below
                    if ((row + 1) <= rows - 1) {
                        if (tileArray[row + 1][col].isMine() == true) {
                            count += 1;
                        }
                    }
                    //bottom right
                    if ((row + 1) <= rows - 1 && (col + 1) <= columns - 1) {
                        if (tileArray[row + 1][col + 1].isMine() == true) {
                            count += 1;
                        }
                    }
                    tileArray[i][j].setValue(Integer.toString(count));


                } else {
                    continue;
                }


            }
        }

    }


    //printing the board
    public String createBoard() {

        initialiseTiles();
        String strBoard = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != columns - 1) {
                    strBoard += tileArray[i][j].toStringDisplay() + "|";  //for each column, add a divider
                } else {
                    strBoard += tileArray[i][j].toStringDisplay() + "\n"; //end of each column add a new line
                }
            }
            if (i != rows - 1) {
                String horizontalDivider = new String(new char[rows - 1]).replace("\0", "---+");
                strBoard += horizontalDivider + "---" + "\n";  //for each row add a new line and divider
            } else {
                strBoard += " ";
            }
        }
        return strBoard;

    }

    public int mineCounter() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.tileArray[i][j].isMine() == true) {
                    count++;
                }


            }
        }
        return count;
    }

    public int revealedTileCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.tileArray[i][j].isHidden() == false) {
                    count++;
                }
            }
        }
        return count;
    }


    public String returnBoard() {
        String strBoard = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != columns - 1) {
                    strBoard += tileArray[i][j].toStringDisplay() + "|";  //for each column, add a divider
                } else {
                    strBoard += tileArray[i][j].toStringDisplay() + "\n"; //end of each column add a new line
                }
            }
            if (i != rows - 1) {
                String horizontalDivider = new String(new char[rows - 1]).replace("\0", "---+");
                strBoard += horizontalDivider + "---" + "\n";  //for each row add a new line and divider
            } else {
                strBoard += " ";
            }
        }
        return strBoard;
    }

    public static void game() {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.createBoard();
        System.out.println(board.createBoard());

        while (true) {

            System.out.print("Would you like to place a flag (type- f) or reveal a tile(type- r): ");
            String flagOrTile = scanner.nextLine();
            System.out.print("Enter desired row between 1 and " + board.rows + ": ");
            int userSelectedRow = scanner.nextInt();
            System.out.print("Enter desired column between 1 and " + board.columns + ": ");
            int userSelectedColumn = scanner.nextInt();

            if (flagOrTile.equalsIgnoreCase("f") || flagOrTile.equalsIgnoreCase("flag")) { //user chooses to place flag, tile is displayed as F
                board.tileArray[userSelectedRow - 1][userSelectedColumn - 1].setDisplay("F");
                System.out.println(board.returnBoard());
                String minusLine = scanner.nextLine(); //gets rid of the additional 'buffer line'

            } else if (flagOrTile.equalsIgnoreCase("r") || flagOrTile.equalsIgnoreCase("r")) { //user reveals a tile
                board.tileArray[userSelectedRow - 1][userSelectedColumn - 1].setHidden(false);
                board.tileArray[userSelectedRow - 1][userSelectedColumn - 1].showTile();
                String minusLine = scanner.nextLine(); //gets rid of the additional 'buffer line'
                if (board.tileArray[userSelectedRow - 1][userSelectedColumn - 1].isMine() == true) { //if user hits mine, reveal the board and end the program

                    for (int i = 0; i < board.getRows(); i++) {
                        for (int j = 0; j < board.getColumns(); j++) {
                            board.tileArray[i][j].setHidden(false);
                            board.tileArray[i][j].showTile();
                        }
                    }

                    System.out.println(board.returnBoard());
                    System.out.println("You hit a mine! RIP");
                    System.exit(0);
                } else if (board.mineCounter() == ((board.getRows() * board.getColumns()) - board.revealedTileCount())) { //if all non-mine tiles are revealed: user wins
                    System.out.println(board.returnBoard());
                    System.out.println("YOU WIN! :)");
                    System.exit(0);
                } else if (board.tileArray[userSelectedRow - 1][userSelectedColumn - 1].getValue().equalsIgnoreCase("0")) {

                    int row = userSelectedRow - 1;
                    int col = userSelectedColumn - 1;
                    //top left
                    if ((row - 1) >= 0 && (col - 1) >= 0) {
                        if (board.tileArray[row - 1][col - 1].isMine() == false) {
                            board.tileArray[row - 1][col - 1].setHidden(false);
                            board.tileArray[row - 1][col - 1].showTile();
                        }
                    }
                    //above
                    if (row - 1 >= 0) {
                        if (board.tileArray[row - 1][col].isMine() == false) {
                            board.tileArray[row - 1][col].setHidden(false);
                            board.tileArray[row - 1][col].showTile();
                            if (board.tileArray[row - 1][col].getValue().equalsIgnoreCase("0")) {

                            }
                        }
                    }
                    //top right
                    if ((row - 1) >= 0 && (col + 1) <= board.getColumns() - 1) {
                        if (board.tileArray[row - 1][col + 1].isMine() == false) {
                            board.tileArray[row - 1][col + 1].setHidden(false);
                            board.tileArray[row - 1][col + 1].showTile();
                        }
                    }
                    //left
                    if ((col - 1) >= 0) {
                        if (board.tileArray[row][col - 1].isMine() == false) {
                            board.tileArray[row][col - 1].setHidden(false);
                            board.tileArray[row][col - 1].showTile();
                        }
                    }
                    //right
                    if ((col + 1) <= board.getColumns() - 1) {
                        if (board.tileArray[row][col + 1].isMine() == false) {
                            board.tileArray[row][col + 1].setHidden(false);
                            board.tileArray[row][col + 1].showTile();
                        }
                    }
                    //bottom left
                    if ((row + 1) <= board.getRows() - 1 && (col - 1) >= 0) {
                        if (board.tileArray[row + 1][col - 1].isMine() == false) {
                            board.tileArray[row + 1][col - 1].setHidden(false);
                            board.tileArray[row + 1][col - 1].showTile();
                        }
                    }
                    //below
                    if ((row + 1) <= board.getRows() - 1) {
                        if (board.tileArray[row + 1][col].isMine() == false) {
                            board.tileArray[row + 1][col].setHidden(false);
                            board.tileArray[row + 1][col].showTile();
                        }
                    }
                    //bottom right
                    if ((row + 1) <= board.getRows() - 1 && (col + 1) <= board.getColumns() - 1) {
                        if (board.tileArray[row + 1][col + 1].isMine() == false) {
                            board.tileArray[row + 1][col + 1].setHidden(false);
                            board.tileArray[row + 1][col + 1].showTile();
                        }
                    }


                    System.out.println(board.returnBoard());
                } else {
                    System.out.println(board.returnBoard());
                }
            }

        }
    }

}


