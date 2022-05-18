import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testTileCreation(){
        Tile test = new Tile(0,0,false);
        Assertions.assertEquals(0,test.getPositionRow(),"Position of row incorrect");

    }

}
