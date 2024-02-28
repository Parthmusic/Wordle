import java.util.Scanner;
import java.util.Random;

public class WordleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] wordList = { "apple", "happy", "money", "tiger", "watch", "music" };

        String secretWord = wordList[random.nextInt(wordList.length)];
        
        int maxAttempts = 6;
        int attempts = 0;
        boolean isGuessed = false;

        System.out.println("Welcome to Wordle!");
        System.out.println("You have 6 attempts to guess the 5-letter word.");

        while (attempts < maxAttempts && !isGuessed) {
            System.out.println("\nAttempt #" + (attempts + 1));
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (guess.length() != 5) {
                System.out.println("Your guess should be exactly 5 letters long.");
                continue;
            }

            if (secretWord.equals(guess)) {
                isGuessed = true;
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
            } else {
                System.out.println("Incorrect guess. Here's a hint:");
                for (int i = 0; i < 5; i++) {
                    char secretChar = secretWord.charAt(i);
                    char guessChar = guess.charAt(i);

                    if (secretChar == guessChar) {
                        System.out.print("Green ");
                    } else if (secretWord.contains(String.valueOf(guessChar))) {
                        System.out.print("Yellow ");
                    } else {
                        System.out.print("Grey ");
                    }
                }

                attempts++;
            }
        }

        if (!isGuessed) {
            System.out.println("\nSorry, you're out of attempts. The secret word was: " + secretWord);
        }

        scanner.close();
    }
}
