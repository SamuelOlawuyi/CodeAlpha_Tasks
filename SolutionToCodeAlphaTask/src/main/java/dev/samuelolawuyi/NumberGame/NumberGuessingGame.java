package dev.samuelolawuyi.NumberGame;


import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int low = 1;
        int high = 100;
        int maxAttempts = 5;
        int guess = 0;
        int RAND = random.nextInt(high - low + 1) + low;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + low + " and " + high + ". Can you guess it?");

        while (guess < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < low || userGuess > high) {
                System.out.println("Please enter a number between " + low + " and " + high + ".");
            } else if (userGuess < RAND) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > RAND) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the correct number, which is " + RAND + ".");
                break;
            }
            guess++;
        }

        if (guess == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of guesses. The correct number was " + RAND + ".");
        }

        scanner.close();
    }
}
