import java.util.Scanner;

public class Board {
    private int rows = 6;
    private int columns = 6;
    private int mines = 10;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    Tile[][] tileArray = new Tile[rows][columns]; //instantiate an array of tiles

    //initialise the board
    public void initialiseTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tileArray[i][j] = new Tile(i, j, "0", "?" ,true, false, false); //assigns each tile its relative position and sets it hidden

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
                if (tileArray[i][j].isMine() == false){
                    int count = 0;
                    int row = tileArray[i][j].getPositionRow();
                    int col = tileArray[i][j].getPositionColumn();
                    //top left
                    if ((row-1)>=0 && (col-1)>=0){
                        if (tileArray[row-1][col-1].isMine()==true){
                            count=+1;}
                    }
                    //above
                    if (row-1>=0){
                        if (tileArray[row-1][col].isMine()==true){
                            count+=1;}
                    }
                    //top right
                    if ((row-1)>=0 && (col+1)<=columns-1){
                        if (tileArray[row-1][col+1].isMine()==true){
                            count+=1;}
                    }
                    //left
                    if ((col-1)>=0){
                        if(tileArray[row][col-1].isMine()==true){
                            count+=1;}
                    }
                    //right
                    if ((col+1)<=columns-1){
                        if (tileArray[row][col+1].isMine()==true){
                            count+=1;}
                    }
                    //bottom left
                    if ((row+1)<=rows-1 && (col-1)>=0){
                        if (tileArray[row+1][col-1].isMine()==true)
                            count+=1;
                    }
                    //below
                    if ((row+1)<=rows-1){
                        if (tileArray[row+1][col].isMine()==true){
                            count+=1;}
                    }
                    //bottom right
                    if ((row+1)<=rows-1 && (col+1)<=columns-1){
                        if (tileArray[row+1][col+1].isMine()==true){
                            count+=1;}
                    }
                    tileArray[i][j].setValue(Integer.toString(count));



                }
                else {continue;}


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

    public String returnBoard(){
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

    public static void game(){

        Scanner scanner =new Scanner(System.in);
        Board board = new Board();

        System.out.print("Welcome to Minesweeper!\n");
        /*
        System.out.print("Select you difficulty- Easy, Medium or Hard: ");
        String userDifficulty = scanner.nextLine();
        if (userDifficulty.equalsIgnoreCase("easy") || userDifficulty.equalsIgnoreCase("e")) {
            board.setRows(5);
            board.setColumns(5);
            board.setMines(5);
        }
        else if (userDifficulty.equalsIgnoreCase("medium") || userDifficulty.equalsIgnoreCase("m")){
            board.setRows(9);
            board.setColumns(9);
            board.setMines(15);
        }
        else {
            System.out.println("YOU HAVE CHOSEN PAIN");
            board.setRows(9);
            board.setColumns(9);
            board.setMines(25);}

         */

        System.out.println(board.createBoard());

        while(true) {
            System.out.print("Enter desired row between 1 and "+ board.rows +": ");
            int userSelectedRow = scanner.nextInt();
            System.out.print("Enter desired column between 1 and "+ board.columns+": ");
            int userSelectedColumn = scanner.nextInt();
            board.tileArray[userSelectedRow-1][userSelectedColumn-1].setHidden(false);
            board.tileArray[userSelectedRow-1][userSelectedColumn-1].showTile();
            if (board.tileArray[userSelectedRow-1][userSelectedColumn-1].isMine()==true){
                System.out.println("You hit a mine! RIP");
                System.exit(0);
            }
            else{
            System.out.println(board.returnBoard());}
        }
    }


}
