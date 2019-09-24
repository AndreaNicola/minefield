import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MinefieldMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size;

        do {
            System.out.print("Minefield size (2-20): ");
            size = scanner.nextInt();
        } while (!(2 <= size && size <= 20));

        int minesNumber;
        do {
            System.out.print("Mines number (1+): ");
            minesNumber = scanner.nextInt();
        } while (!(1 <= minesNumber));

        LocalDateTime beginTime = LocalDateTime.now();
        GameMap gameMap = new GameMap(size, minesNumber);
        boolean gameInProgress = true;

        do {


            gameMap.printMap();

            int row, col;
            do {
                System.out.print("Row: ");
                row = scanner.nextInt();
                System.out.print("Col: ");
                col = scanner.nextInt();
            } while (!gameMap.isCoordInMap(row, col));


            gameMap.openCell(row, col);
            boolean minedCell = gameMap.isMine(row, col);

            if (minedCell) {
                System.out.println(Colors.ANSI_RED + "KABOOM!!!" + Colors.ANSI_RESET);
                gameInProgress = false;
            }

            if (gameInProgress && gameMap.noMoreCellsToOpen()) {
                gameInProgress = false;
                System.out.println(Colors.ANSI_YELLOW + "VICTORY!!!" + Colors.ANSI_RESET);

            }

            long elapsedSeconds = ChronoUnit.SECONDS.between(beginTime, LocalDateTime.now());

            long elapsedSecondsPrint = elapsedSeconds % 60;
            long elapsedMinutesPrint = elapsedSeconds / 60;


            System.out.println("Elapsed time: " + elapsedMinutesPrint + " minutes and " + elapsedSecondsPrint + " seconds");

        } while (gameInProgress);

        if (!gameInProgress) {
            gameMap.openMap();
            gameMap.printMap();
        }

        scanner.close();


    }

}
