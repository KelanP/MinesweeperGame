

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");
        Board board = new Board();
        board.initialiseBoard();
        System.out.println(board.createBoard());

    }
}
