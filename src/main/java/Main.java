import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        System.out.print("Select you difficulty- Easy, Medium or Hard: ");
        String userDifficulty = scanner.nextLine();
        if (userDifficulty.equalsIgnoreCase("easy") || userDifficulty.equalsIgnoreCase("e")) {
            board.setRows(5);
            board.setColumns(5);
            board.setMines(5);

        } else if (userDifficulty.equalsIgnoreCase("medium") || userDifficulty.equalsIgnoreCase("m")) {
            board.setRows(7);
            board.setColumns(7);
            board.setMines(15);
        } else {
            System.out.println("YOU HAVE CHOSEN PAIN");
            board.setRows(9);
            board.setColumns(9);
            board.setMines(28);
        }
        Board.game();

    }
}
