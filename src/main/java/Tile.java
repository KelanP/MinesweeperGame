public class Tile {

    //attributes
    private int positionRow;
    private int positionColumn;
    private boolean hidden;

    //constructor

    public Tile(int positionRow, int positionColumn, boolean hidden) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.hidden = hidden;
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

    @Override
    public String toString() {
        return "Tile{" +
                "positionRow=" + positionRow +
                ", positionColumn=" + positionColumn +
                ", hidden=" + hidden +
                '}';
    }
}
