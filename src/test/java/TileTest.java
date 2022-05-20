import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testTileCreation(){
        Tile testTile = new Tile(1,2,"3","?",false,false,true);
        Assertions.assertEquals(1,testTile.getPositionRow(),"Position of row incorrect");
        Assertions.assertEquals(2,testTile.getPositionColumn(),"Incorrect column");
        Assertions.assertEquals("3",testTile.getValue(),"Incorrect value");
        Assertions.assertEquals("?",testTile.getDisplay(),"Incorrect display value");
        Assertions.assertEquals(false,testTile.isHidden(),"Incorrect boolean for hidden");
        Assertions.assertEquals(false,testTile.isMine(),"Incorrect boolean for mine");
        Assertions.assertEquals(true,testTile.isFlagged(),"Incorrect boolean for flag");
    }



}
