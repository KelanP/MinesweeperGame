public class Tile {

    //attributes
    private int positionRow;
    private int positionColumn;
    private int value;
    private boolean hidden;
    private boolean isMine;
    private boolean isFlagged;

    //constructor

    public Tile(int positionRow, int positionColumn,int value, boolean hidden, boolean isMine, boolean isFlagged) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.value = value;
        this.hidden = hidden;
        this.isMine = isMine;
        this.isFlagged = isFlagged;
    }


    //methods

    //getters and setters

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public void setPositionColumn(int positionColumn) {
        this.positionColumn = positionColumn;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "positionRow=" + positionRow +
                ", positionColumn=" + positionColumn +
                ", value=" + value +
                ", hidden=" + hidden +
                ", isMine=" + isMine +
                ", isFlagged=" + isFlagged +
                '}';
    }

    public String toStringValue() {
        return " " + value + " ";
    }
}
