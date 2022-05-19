import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    int rows = 6;
    int columns = 6;
    int mines = 15;

    Tile[][] tileArray = new Tile[rows][columns]; //instantiate an array of tiles

    //initialise the board
    public void initialiseBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tileArray[i][j] = new Tile(i, j, "0", true, false, false); //assigns each tile its relative position and sets it hidden

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

        initialiseBoard();
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
                String horizontalDivider = new String(new char[rows - 1]).replace("\0", "---+");
                strBoard += horizontalDivider + "---" + "\n";  //for each row add a new line and divider
            } else {
                strBoard += " ";
            }
        }
        return strBoard;

    }


}
