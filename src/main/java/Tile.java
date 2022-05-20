public class Tile {

    private String display;
    //attributes
    private int positionRow;
    private int positionColumn;
    private String value;
    private boolean hidden;
    private boolean isMine;
    private boolean isFlagged;

    //constructor

    public Tile(int positionRow, int positionColumn,String value,String display, boolean hidden, boolean isMine, boolean isFlagged) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.value = value;
        this.display = display;
        this.hidden = hidden;
        this.isMine = isMine;
        this.isFlagged = isFlagged;
    }


    //methods
    public void mineIcon(){
        if(Tile.this.isMine()){
            Tile.this.setValue("x"); //sets value to unicode bomb character💣
        }
    }

    public void showTile(){
        if(!Tile.this.isHidden()){
            Tile.this.setDisplay(Tile.this.getValue());
        }
    }

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

    public String getDisplay() {
        return display;
    }
    public void setDisplay(String display) {
        this.display = display;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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


    public String toStringDisplay() {
        return " " + display + " ";
    }

    public String toStringValue() {
        return " " + value + " ";
    }

}
