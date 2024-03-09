package task3.atmInterface;
import java.util.Scanner;

public class Main extends atmMachine{
    public Main(client client){
        super(client);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int accountNumber, pin;
        accountNumber = 0;
        pin = 0;

        while (!Main.verifyAccount(accountNumber)) {
            System.out.println("Please enter valid Account Number: ");
            try {
                accountNumber = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("That account does not exist");
                continue;
            }
        }

        while (!Main.verifyPin(pin, accountNumber)){
            System.out.println( "Please Enter Your PIN: ");
            try {
                pin = Integer.parseInt(sc.nextLine().trim());
                
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println( "Invalid input! Please enter a correct PIN.");
            }
        }

        client client = new client(accountNumber, pin, atmMachine.getBalance(accountNumber));
        Main atm = new Main(client);

        boolean transaction_complete = false;

        while (!transaction_complete) {

            System.out.println("Please select a character: \n 1 Withdrawal \n 2 Deposit \n 3 Check Balance \n 4 Quit");
            int transaction = sc.nextInt();

            switch(transaction){
                case 1:
                System.out.println("Please enter an amount (e.g. 300.00)");
                double amount = sc.nextDouble();
                atm.withdrawal(amount);
                break;
                case 2:
                System.out.println("Please enter an amount (e.g. 300.00)");
                amount = sc.nextDouble();
                atm.withdrawal(amount);
                break;
                case 3:
                System.out.println("Please enter an amount (e.g. 300.00)");
                amount = sc.nextDouble();
                atm.withdrawal(amount);
                break;
                case 4:
                System.out.println("GoodBye! Thank you for using our ATM service!");
                transaction_complete=true;
                default : 
                System.out.println("Unknown command! Try again");


            }
        }
        sc.close();
        


    }
}