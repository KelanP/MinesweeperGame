
public class Board {
    int rows = 5;
    int columns = 5;
    int mines = 5;

    Tile[][] tileArray = new Tile[rows][columns]; //instantiate an array of tiles

    //initialise the board
    public void initialiseBoard(){


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tileArray[i][j] = new Tile(i,j,0,true,false,false); //assigns each tile its relative position and sets it hidden

            }

        }

        for(int x=mines;x>0;x--){
            int randomRow = (int)(Math.random() * (rows-1));
            int randomColumn = (int)(Math.random() * (columns-1));

            tileArray[randomRow][randomColumn].setMine(true);
            tileArray[randomRow][randomColumn].setValue(1);

        }

    }

    //printing the board
    public String createBoard(){
        String strBoard = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != columns - 1) {
                    strBoard += tileArray[i][j].toStringValue() + "|";  //for each column, add a divider
                } else {
                    strBoard += tileArray[i][j].toStringValue() + "\n"; //end of each column add a new line
                }
            }
            if (i != rows - 1) {
                String horizontalDivider = new String(new char[rows-1]).replace("\0", "---+");
                strBoard += horizontalDivider + "---" + "\n";  //for each row add a new line and divider
            } else {
                strBoard += " ";
            }
        }
        return strBoard;

    }




}
