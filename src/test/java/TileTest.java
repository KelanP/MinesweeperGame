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

    @Test
    public void testSetters(){
        Tile tileSetter = new Tile(5,6,null,"?",true,true,false);
        tileSetter.setPositionRow(1);
        Assertions.assertEquals(1,tileSetter.getPositionRow(),"row wrong");
        tileSetter.setPositionColumn(2);
        Assertions.assertEquals(2,tileSetter.getPositionColumn(),"column wrong");
        tileSetter.setValue("x");
        Assertions.assertEquals("x",tileSetter.getValue(),"value wrong");
        tileSetter.setDisplay("F");
        Assertions.assertEquals("F",tileSetter.getDisplay(),"display value wrong");
        tileSetter.setHidden(false);
        Assertions.assertEquals(false, tileSetter.isHidden(),"Incorrect boolean for hidden");
        tileSetter.setMine(false);
        Assertions.assertEquals(false, tileSetter.isMine(),"Incorrect boolean for mine");
        tileSetter.setFlagged(true);
        Assertions.assertEquals(true,tileSetter.isFlagged(),"Incorrect boolean for flag");

    }

    @Test
    public void testToString(){
        Tile tileToString = new Tile(5,6,null,"?",true,true,false);
        Assertions.assertEquals("Tile{" + "positionRow=" + tileToString.getPositionRow() +
                ", positionColumn=" + tileToString.getPositionColumn() +
                ", value=" + tileToString.getValue() +
                ", hidden=" + tileToString.isHidden() +
                ", isMine=" + tileToString.isMine() +
                ", isFlagged=" + tileToString.isFlagged() +
                '}', tileToString.toString(), "toString not created correctly");
        Assertions.assertEquals(" " + tileToString.getDisplay() + " ",tileToString.toStringDisplay(),"toStringDisplay not working");
        Assertions.assertEquals(" "+tileToString.getValue()+" ",tileToString.toStringValue());

    }



}
