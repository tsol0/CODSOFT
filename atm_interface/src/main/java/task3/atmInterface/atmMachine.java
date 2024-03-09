package task3.atmInterface;
import java.util.Map;
import java.util.HashMap;

public abstract class atmMachine implements atm{

    protected int currentAccountNumber;
    private client client;

    private static Map<Integer, client> clientsAccounts;

    static {
        clientsAccounts = new HashMap<>();
        addClient(1618255756, 84255, 2050.90);
        addClient(1554578205, 12894, 100.00);
        addClient(1311047609, 68870, 20.00);
        addClient(1554505742, 91787, 0.00);

    }

    private static void addClient(int accountNumber, int Pin, double balance){
        client client = new client(accountNumber, Pin, balance);
        clientsAccounts.put(accountNumber, client);
    }

    @Override
    public double checkBalance() {
        double standingBalance = getClientBalance(currentAccountNumber);
        System.out.println("Your Balance is R " +standingBalance);
        return standingBalance;
    }

    @Override
    public double deposit(double amount) {
        double currentBalance = getClientBalance(currentAccountNumber);
        if (amount > 0){
            currentBalance += amount;
            updateBalance(currentAccountNumber, currentBalance);
            System.out.println("Deposited " + amount + ". Current balance is: " + currentBalance);
            checkBalance();
            return currentBalance;
        }
        System.out.println(amount + " cannot be a less than zero.");
        return currentBalance;
    }

    @Override
    public double withdrawal(double amount) {
        double currentBalance = getClientBalance(currentAccountNumber);
        if (amount <= currentBalance){
            currentBalance -= amount;
            updateBalance(currentAccountNumber, currentBalance);
            System.out.println("Withdrew " + amount + ". Remaining balance is: " + currentBalance);
            checkBalance();
            return currentBalance;
        }
         System.out.println("Insufficient funds in account. Please try again with a smaller amount.");
        return currentBalance;
        // return 0;
    }
    
}
