package Vpackage;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        int rounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int randomNum = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + minNum + " and " + maxNum + ".");
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); 
                    continue;
                }

                if (userGuess < minNum || userGuess > maxNum) {
                    System.out.println("Please guess a number between " + minNum + " and " + maxNum + ".");
                } else if (userGuess == randomNum) {
                    System.out.println("Congratulations! You guessed the correct number " + randomNum + " in " + (attempts + 1) + " attempts!");
                    totalScore += attempts + 1;
                    break;
                } else if (userGuess < randomNum) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNum + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Your total score is " + totalScore + " in " + rounds + " rounds.");
        scanner.close();
    }
}
