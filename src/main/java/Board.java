
public class Board {
    int rows = 5;
    int columns = 5;
    int mines = 5;
    String [][] board = new String[rows][columns];

    //initialise the board
    public void initialiseBoard(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Tile tileArray[][] = new Tile[i][j]; //instantiate an array of tiles
            }
        }
    }

    //printing the board
    public String createBoard(){
        String strBoard = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != columns - 1) {
                    strBoard += board[i][j] + "|";  //for each column, add a divider
                } else {
                    strBoard += board[i][j] + "\n"; //end of each column add a new line
                }
            }
            if (i != rows - 1) {
                String horizontalDivider = new String(new char[rows-1]).replace("\0", "----+");
                strBoard += horizontalDivider + "----" + "\n";  //for each row add a new line and divider
            } else {
                strBoard += " ";
            }
        }
        return strBoard;

    }




}
