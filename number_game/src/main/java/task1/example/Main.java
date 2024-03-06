package task1.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int randomNum = random.nextInt(1,100);
        int user_guess = 0;
        int guess_count = 0;

        while (user_guess != randomNum){
            try {
                System.out.println("Guess the number generated");
                user_guess = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("PLease enter valid number");
                continue;
            }

            guess_count++;
            if (user_guess > randomNum){
                System.out.println("Your guess is too high! Try again.");
            } else if (user_guess < randomNum){
                System.out.println("Your guess is too low! Try again.");
            }

            System.out.printf("Guess attempt : %d\n", guess_count);

            if (guess_count == 3){
                System.out.printf("You have reached your limit of guesses %d\n", guess_count);
                break;
            }
        }
        System.out.println("The number is " + randomNum);

        sc.close();


    }
}