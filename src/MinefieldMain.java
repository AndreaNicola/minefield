import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MinefieldMain {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int dimensione;

        do {
            System.out.print("Dimensione del campo minato (2-20): ");
            dimensione = scanner.nextInt();
        } while (!(2 <= dimensione && dimensione <= 20));

        int numeroMine;
        do {
            System.out.print("Numero delle mine (1+): ");
            numeroMine = scanner.nextInt();
        } while (!(1 <= numeroMine));

        LocalDateTime inizio = LocalDateTime.now();
        Mappa mappa = new Mappa(dimensione, numeroMine);
        boolean partitaInCorso = true;

        do {

            mappa.printMappa();
            System.out.print("Riga: ");
            int riga = scanner.nextInt();
            System.out.print("Colonna: ");
            int colonna = scanner.nextInt();

            mappa.scopriCasella(riga, colonna);
            boolean casellaMina = mappa.isMina(riga,colonna);

            if (casellaMina) {
                System.out.println("KABOOM!!!");
                partitaInCorso = false;
            }

            if (partitaInCorso && mappa.nonCiSonoCaselleDaScoprire()) {
                partitaInCorso = false;
                System.out.println("VITTORIA!!!");

            }

            long secondiTrascorsi = ChronoUnit.SECONDS.between(inizio, LocalDateTime.now());

            long secondiTrascorsiPrint = secondiTrascorsi % 60;
            long minutiTrascorsiPrint = secondiTrascorsi / 60;


            System.out.println("Tempo Trascorso: " + minutiTrascorsiPrint + " minuti e " + secondiTrascorsiPrint + " secondi");

        } while (partitaInCorso);

        if (!partitaInCorso) {
            mappa.scopriMappa();
            mappa.printMappa();
        }


    }

}
