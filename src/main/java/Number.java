public class Number extends Tile {

    //attributes
    int neighbouringMines;

    //constructor

    public Number(int positionRow, int positionColumn, boolean hidden, int neighbouringMines) {
        super(positionRow, positionColumn, hidden);

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

