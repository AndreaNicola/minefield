public class Casella {

    private final boolean mina;
    private boolean scoperta = false;
    private int mineCircostanti;

    public Casella(boolean mina) {
        this.mina = mina;
    }

    public boolean isScoperta() {
        return scoperta;
    }

    public void setScoperta(boolean scoperta) {
        this.scoperta = scoperta;
    }

    public boolean isMina() {
        return mina;
    }

    public int getMineCircostanti() {
        return mineCircostanti;
    }

    public void setMineCircostanti(int mineCircostanti) {
        this.mineCircostanti = mineCircostanti;
    }
}
