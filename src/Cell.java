public class Cell {

    private final boolean mine;
    private boolean open = false;
    private int surroundingMines;

    public Cell(boolean mine) {
        this.mine = mine;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isMine() {
        return mine;
    }

    public int getSurroundingMines() {
        return surroundingMines;
    }

    public void setSurroundingMines(int surroundingMines) {
        this.surroundingMines = surroundingMines;
    }
}
