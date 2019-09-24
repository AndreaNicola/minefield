import java.util.Random;

public class Mappa {

    private final Casella[][] mappa;
    private final int numeroMine;
    private final int dimensione;
    private int caselleScoperte;

    public Mappa(int dimensione, int numeroMine) {

        this.mappa = new Casella[dimensione][dimensione];
        this.numeroMine = numeroMine;
        this.dimensione = dimensione;
        int minePiazzate = 0;

        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                mappa[i][j] = new Casella(minePiazzate < this.numeroMine);
                if (mappa[i][j].isMina()) {
                    minePiazzate++;
                }
            }
        }

        Random random = new Random();
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                int newI = random.nextInt(dimensione);
                int newJ = random.nextInt(dimensione);
                Casella temp = mappa[i][j];
                mappa[i][j] = mappa[newI][newJ];
                mappa[newI][newJ] = temp;
            }
        }

        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                mappa[i][j].setMineCircostanti(calcolaMineCircostanti(i, j));
            }
        }

    }

    public boolean nonCiSonoCaselleDaScoprire() {
        return dimensione * dimensione - numeroMine - caselleScoperte <= 0;
    }

    public void scopriCasella(int i, int j) {

        if (isCoordInMap(i,j) && !mappa[i][j].isScoperta()) {

            mappa[i][j].setScoperta(true);
            caselleScoperte++;

            if (mappa[i][j].getMineCircostanti() == 0) {

                scopriCasella(i - 1, j - 1);
                scopriCasella(i - 1, j);
                scopriCasella(i - 1, j + 1);

                scopriCasella(i, j - 1);
                scopriCasella(i, j + 1);

                scopriCasella(i + 1, j - 1);
                scopriCasella(i + 1, j);
                scopriCasella(i + 1, j + 1);
            }

        }

    }


    public void printMappa() {
        System.out.print("\t");
        for (int i = 0; i < dimensione; i++)
            System.out.print(i + "\t");
        System.out.println();

        for (int i = 0; i < this.dimensione; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.dimensione; j++) {
                if (mappa[i][j].isScoperta()) {

                    if (mappa[i][j].isMina())
                        System.out.print("M\t");
                    else {
                        if (mappa[i][j].getMineCircostanti() == 0) {
                            System.out.print(" \t");
                        } else {
                            System.out.print(mappa[i][j].getMineCircostanti() + "\t");
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
        return 0 <= i && i < dimensione && 0 <= j && j < dimensione;
    }

    private int calcolaMineCircostanti(int i, int j) {

        return calcolaMineCircostantiAux(i - 1, j - 1) +
                calcolaMineCircostantiAux(i - 1, j) +
                calcolaMineCircostantiAux(i - 1, j + 1) +

                calcolaMineCircostantiAux(i, j - 1) +
                calcolaMineCircostantiAux(i, j + 1) +

                calcolaMineCircostantiAux(i + 1, j - 1) +
                calcolaMineCircostantiAux(i + 1, j) +
                calcolaMineCircostantiAux(i + 1, j + 1);

    }

    private int calcolaMineCircostantiAux(int i, int j) {
        return isCoordInMap(i, j) && mappa[i][j].isMina() ? 1 : 0;
    }

    public void scopriMappa() {
        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                this.scopriCasella(i, j);
            }
        }
    }

    public boolean isMina(int i, int j) {
        return isCoordInMap(i,j) && mappa[i][j].isMina();
    }
}
