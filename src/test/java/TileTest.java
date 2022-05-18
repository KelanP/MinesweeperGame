import org.junit.jupiter.api.*;


public class TileTest {

    @Test
    public void tileCreationTest(){
    Tile test = new Tile(0,0,false);
        Assertions.assertEquals(0,test.getPositionRow(),"Position of row incorrect");

    }

}
