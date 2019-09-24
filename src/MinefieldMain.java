import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MinefieldMain {

    public static void main(String[] args)  {

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
            System.out.print("Row: ");
            int row = scanner.nextInt();
            System.out.print("Col: ");
            int col = scanner.nextInt();

            gameMap.openCell(row, col);
            boolean minedCell = gameMap.isMine(row,col);

            if (minedCell) {
                System.out.println("KABOOM!!!");
                gameInProgress = false;
            }

            if (gameInProgress && gameMap.noMoreCellsToOpen()) {
                gameInProgress = false;
                System.out.println("VICTORY!!!");

            }

            long elapsedSeconds = ChronoUnit.SECONDS.between(beginTime, LocalDateTime.now());

            long elapsedSecondsPrint = elapsedSeconds % 60;
            long elapsedMinutesPrint = elapsedSeconds / 60;


            System.out.println("Elapsed time: " + elapsedMinutesPrint + " minutes and" + elapsedSecondsPrint + " seconds");

        } while (gameInProgress);

        if (!gameInProgress) {
            gameMap.openMap();
            gameMap.printMap();
        }

        scanner.close();


    }

}
