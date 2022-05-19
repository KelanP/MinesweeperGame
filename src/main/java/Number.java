public class Number extends Tile {

    //attributes
    int neighbouringMines;

    //constructor

    public Number(int positionRow, int positionColumn,String value ,boolean hidden, boolean isMine, boolean isFlagged, int neighbouringMines) {
        super(positionRow, positionColumn,value,hidden,isMine,isFlagged);

        this.neighbouringMines = neighbouringMines;
    }


    //methods


    public int getNeighbouringMines() {
        return neighbouringMines;
    }

    public void setNeighbouringMines(int neighbouringMines) {
        this.neighbouringMines = neighbouringMines;
    }
}

