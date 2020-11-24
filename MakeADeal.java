import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Program Name
 * <p>
 * brief description of the program
 * <p>
 * a list of your sources of help (if any)
 *
 * @author Reuben Varghese, lab sec B02
 * @version date of completion
 */

public class MakeADeal {

    public static void main(String[] args) {

        Random r = new Random();

        boolean continueGame = true;

        while (continueGame) {

            String[] doors = new String[3];

            for (int i = 0; i < 3; i++) {
                doors[i] = "JUNK!";
            }
            int goldSpot = r.nextInt(3);

            doors[goldSpot] = "GOLD!";


            Scanner scanner = new Scanner(System.in);

            System.out.println("DOOR 1\tDOOR 2\tDOOR 3");
            System.out.println("Choose a Door!");
            int firstChoice = scanner.nextInt() - 1;
            scanner.nextLine();
            int junkSpot = -1;
            int random = r.nextInt(3);


            if (doors[firstChoice].equals("GOLD!")) {
                while (random == firstChoice) {
                    random = r.nextInt(3);
                }

                junkSpot = random;
                System.out.printf("Door %d is JUNK!\n", junkSpot + 1);
            } else {

                for (int i = 0; i < 3; i++) {
                    if(i != firstChoice && doors[i].equals("JUNK!")) {
                        System.out.printf("Door %d is JUNK!\n", i + 1);
                        junkSpot = i;
                        break;
                    }
                }

            }


            System.out.println("Do you want to switch doors? (Y/N)");

            String secondChoice = scanner.nextLine().toUpperCase();


            int otherDoor = 3 - (firstChoice + junkSpot);
            if (secondChoice.equals("Y")) {

                System.out.printf("You switched to Door %d ... %s\n", otherDoor + 1, doors[otherDoor]);

            } else {
                System.out.printf("You stayed on Door %d ... %s\n", firstChoice + 1, doors[firstChoice]);
            }

            System.out.println(Arrays.toString(doors));

            System.out.println("Do you want to play again? (Y/N)");
            String playAgain = scanner.nextLine().toUpperCase();

            if (playAgain.equals("N")) {
                continueGame = false;
            }

        }

        System.out.println("Thanks for playing!");


    }

}
