import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testGettersAndSetters(){
        Board board = new Board();
        board.setRows(5);
        board.setColumns(10);
        board.setMines(20);
        Assertions.assertEquals(10,board.getColumns(),"correct number of columns");
        Assertions.assertEquals(5,board.getRows(),"correct number of rows");

    }
}
