import java.util.Random;
import java.util.Scanner;

public class TASK1 {

    public static void main(String[] args) {

        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        Boolean playagain = true;
        Scanner input = new Scanner(System.in);
        int guess;

        while (playagain) {
            System.out.println("I'm thinking of a number between 1 and 100. Try to guess it.");
            for (int x = 10; x > 0; x--) {
                System.out.println("You have " + x + " guesses left.");
                System.out.print("Your guess: ");
                guess = input.nextInt();

                if (Math.abs(guess - number) <= 10) {
                    System.out.println("Very close!");
                } else if (Math.abs(guess - number) <= 25) {
                    System.out.println("Close!");
                } else {
                    System.out.println("Too far!");
                }

                if (guess == number) {
                    System.out.println("You got it! The number was " + number);
                    System.out.println("Your Score is " + (10 - x));
                    break;
                }
            }
            System.out.print("Do you want to stop? (yes/no): ");
            playagain = !input.next().equals("yes");

        } 

        System.out.println("Thanks for playing!");
        input.close();

    }

}
