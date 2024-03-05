package task1.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int randomNum = random.nextInt(1,100);
        int user_guess = 0;
        while (user_guess != randomNum){
            System.out.println("Guess the number generated");
            user_guess = sc.nextInt();
            
            if (user_guess > randomNum){
                System.out.println("Your guess is too high! Try again.");
            } else if (user_guess < randomNum){
                System.out.println("Your guess is too low! Try again.");
            }
        }

        sc.close();



    }
}