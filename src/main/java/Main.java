import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Minesweeper!");

        int rows = 6;
        int columns = 5;
        int mines = 5;

        int[][] grid= new int[rows][columns]; //2D array which will act as the grid of tiles


        //set position of each tile and hides them
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j]=0;
            }
        }

       //Assigns a value of '-1' to random positions in the array which will signify a mine
        for(int x=mines;x>0;x--){
            int randomColumn = (int)(Math.random() * columns);
            int randomRow = (int)(Math.random() * rows);
            grid[randomRow][randomColumn]=-1;
            new Mine(randomColumn,randomRow,true); //creates a mine object
        }

        //Determines the number of neighbouring mines
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

            }
        }

        //Prints out all objects
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf(String.valueOf(grid[i][j] + "  "));
            }
            System.out.println();
        }









    }
}
