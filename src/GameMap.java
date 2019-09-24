import java.util.Random;

public class GameMap {

    private final Cell[][] map;
    private final int minesNumber;
    private final int size;
    private int openCells;

    public GameMap(int size, int minesNumber) {

        this.map = new Cell[size][size];
        this.minesNumber = minesNumber;
        this.size = size;
        int placedMines = 0;

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                map[i][j] = new Cell(placedMines < this.minesNumber);
                if (map[i][j].isMine()) {
                    placedMines++;
                }
            }
        }

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int newI = random.nextInt(size);
                int newJ = random.nextInt(size);
                Cell temp = map[i][j];
                map[i][j] = map[newI][newJ];
                map[newI][newJ] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j].setSurroundingMines(calculateSurroundingMines(i, j));
            }
        }

    }

    public boolean noMoreCellsToOpen() {
        return size * size - minesNumber - openCells <= 0;
    }

    public void openCell(int i, int j) {

        if (isCoordInMap(i,j) && !map[i][j].isOpen()) {

            map[i][j].setOpen(true);
            openCells++;

            if (map[i][j].getSurroundingMines() == 0) {

                openCell(i - 1, j - 1);
                openCell(i - 1, j);
                openCell(i - 1, j + 1);

                openCell(i, j - 1);
                openCell(i, j + 1);

                openCell(i + 1, j - 1);
                openCell(i + 1, j);
                openCell(i + 1, j + 1);
            }

        }

    }


    public void printMap() {
        System.out.print("\t");
        for (int i = 0; i < size; i++)
            System.out.print(i + "\t");
        System.out.println();

        for (int i = 0; i < this.size; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.size; j++) {
                if (map[i][j].isOpen()) {

                    if (map[i][j].isMine())
                        System.out.print(Colors.ANSI_RED + "M\t" + Colors.ANSI_RESET);
                    else {
                        if (map[i][j].getSurroundingMines() == 0) {
                            System.out.print(" \t");
                        } else {
                            System.out.print(Colors.ANSI_BLUE + map[i][j].getSurroundingMines() + "\t" + Colors.ANSI_RESET);
                        }
                    }

                } else {
                    System.out.print("X\t");
                }
            }
            System.out.println();
        }
    }

    private boolean isCoordInMap(int i, int j) {
        return 0 <= i && i < size && 0 <= j && j < size;
    }

    private int calculateSurroundingMines(int i, int j) {

        return calculateSurroundingMinesAux(i - 1, j - 1) +
                calculateSurroundingMinesAux(i - 1, j) +
                calculateSurroundingMinesAux(i - 1, j + 1) +

                calculateSurroundingMinesAux(i, j - 1) +
                calculateSurroundingMinesAux(i, j + 1) +

                calculateSurroundingMinesAux(i + 1, j - 1) +
                calculateSurroundingMinesAux(i + 1, j) +
                calculateSurroundingMinesAux(i + 1, j + 1);

    }

    private int calculateSurroundingMinesAux(int i, int j) {
        return isCoordInMap(i, j) && map[i][j].isMine() ? 1 : 0;
    }

    public void openMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.openCell(i, j);
            }
        }
    }

    public boolean isMine(int i, int j) {
        return isCoordInMap(i,j) && map[i][j].isMine();
    }
}
