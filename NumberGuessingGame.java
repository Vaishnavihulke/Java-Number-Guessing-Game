import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // ANSI color codes for a better console experience
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String CYAN = "\u001B[36m";
    static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;
        int gamesPlayed = 0;

        System.out.println(CYAN + "========================================" + RESET);
        System.out.println(CYAN + "       🎯 NUMBER GUESSING GAME" + RESET);
        System.out.println(CYAN + "========================================" + RESET);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I will choose a number between 1 and 100.");
        System.out.println("You have 7 attempts to guess it.");
        System.out.println();

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println(BLUE + "----------------------------------------" + RESET);
            System.out.println("🎮 New Game Started!");
            System.out.println("Guess a number between 1 and 100.");
            System.out.println();

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println(RED + "❌ Invalid input! Please enter a number." + RESET);
                    scanner.next();
                    System.out.println();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println(
                            YELLOW + "⚠️ Please enter a number between 1 and 100." + RESET
                    );
                    System.out.println();
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {

                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;

                    System.out.println();
                    System.out.println(GREEN + "🎉 Congratulations!" + RESET);
                    System.out.println(
                            GREEN + "You guessed the correct number: "
                                    + secretNumber + RESET
                    );
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Score: " + score + "/70");

                    totalScore += score;
                    gamesPlayed++;

                    break;

                } else if (guess < secretNumber) {

                    System.out.println(
                            YELLOW + "⬆️ Too low! Try a higher number." + RESET
                    );

                } else {

                    System.out.println(
                            YELLOW + "⬇️ Too high! Try a lower number." + RESET
                    );
                }

                int remainingAttempts = maxAttempts - attempts;

                if (remainingAttempts > 0) {
                    System.out.println(
                            "Attempts remaining: " + remainingAttempts
                    );
                }

                System.out.println();
            }

            if (!guessedCorrectly) {

                System.out.println();
                System.out.println(RED + "😔 Game Over!" + RESET);
                System.out.println(
                        "You used all " + maxAttempts + " attempts."
                );
                System.out.println(
                        "The correct number was: " + secretNumber
                );

                gamesPlayed++;
            }

            System.out.println();
            System.out.print("Would you like to play again? (Y/N): ");

            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("Y")) {
                playAgain = false;
            }

            System.out.println();
        }

        System.out.println(CYAN + "========================================" + RESET);
        System.out.println("           🏆 GAME SUMMARY");
        System.out.println(CYAN + "========================================" + RESET);
        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Total score: " + totalScore);
        System.out.println();
        System.out.println(GREEN + "Thanks for playing! 🎯" + RESET);
        System.out.println(CYAN + "========================================" + RESET);

        }
    }
}