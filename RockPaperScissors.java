import java.util.Scanner;  // lets us read keyboard input
import java.util.Random;   // lets us generate random numbers

public class RockPaperScissors {

    public static void main(String[] args) {

        // Set up input reader and random number generator
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // The three possible choices stored in an array
        String[] choices = {"rock", "paper", "scissors"};

        // Track wins for player and computer, and current round number
        int playerWins = 0;
        int computerWins = 0;
        int round = 1;

        System.out.println("=== Rock Paper Scissors (Best of 15) ===");

        // Keep playing until someone reaches 8 wins
        while (playerWins < 8 && computerWins < 8) {

            System.out.println("\nRound " + round);
            System.out.print("Enter rock, paper, or scissors: ");

            // Read player input, convert to lowercase so "Rock" and "rock" both work
            String playerChoice = scanner.nextLine().toLowerCase();

            // Check for invalid input — if bad, redo the same round
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid input. Try again.");
                continue; // redo same round
            }

            // Computer randomly picks from the choices array
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Compare choices to decide round outcome
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
                // ties do NOT count — round number stays the same

            } else if (
                (playerChoice.equals("rock")     && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper")    && computerChoice.equals("rock"))     ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                // All three ways the player can win
                System.out.println("You win this round!");
                playerWins++;
                round++;

            } else {
                // Everything else = computer wins
                System.out.println("Computer wins this round!");
                computerWins++;
                round++;
            }

            // Show running score after each round
            System.out.println("Score -> You: " + playerWins + " | Computer: " + computerWins);
        }

        // Print final result once someone hits 8 wins
        System.out.println("\n=== Final Result ===");
        if (playerWins == 8) {
            System.out.println("You win the match!");
        } else {
            System.out.println("Computer wins the match!");
        }

        System.out.println("Final Score -> You: " + playerWins + " | Computer: " + computerWins);

        scanner.close(); // good habit: close the scanner when done
    }
}
