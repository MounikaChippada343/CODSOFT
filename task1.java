
import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRoundsWon = 0;
        boolean playAgain = true;

        System.out.println("=== WELCOME TO THE NUMBER GAME ===");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Range 1 to 100
            int maxAttempts = 5;
            int attemptsTaken = 0;
            boolean hasWon = false;

            System.out.println("\nNew Round Started!");
            System.out.println("I've picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsTaken < maxAttempts) {
                System.out.print("Attempt " + (attemptsTaken + 1) + ": Enter your guess: ");
                
                // Handle non-integer input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); 
                    continue;
                }

                int userGuess = scanner.nextInt();
                attemptsTaken++;

                if (userGuess == targetNumber) {
                    System.out.println("CORRECT! You found it in " + attemptsTaken + " attempts.");
                    hasWon = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasWon) {
                System.out.println("Out of attempts! The correct number was: " + targetNumber);
            }

            // Display Score & Replay Option
            System.out.println("Total Rounds Won: " + totalRoundsWon);
            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.startsWith("y");
        }

        System.out.println("\nFinal Score: " + totalRoundsWon + " rounds won.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}