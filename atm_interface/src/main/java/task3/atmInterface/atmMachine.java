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

    public static Map<Integer, client> getClientDetails(){
        return  clientsAccounts;
    }

    private static void addClient(int accountNumber, int Pin, double balance){
        client client = new client(accountNumber, Pin, balance);
        clientsAccounts.put(accountNumber, client);
    }

    public client getClientByAccountNumber(int accountNumber){
        return  clientsAccounts.get(accountNumber);
    }

    public void setCurrentAccountNo(int accountNumber){
        this.currentAccountNumber = accountNumber;
    }

    public atmMachine(client client){
        this.client = client;
    }
    
    public static double getBalance(int currentAccountNumber) {
        for (Map.Entry<Integer, client>  entry : clientsAccounts.entrySet()) {
            client client = entry.getValue();
            if (client.getAccountNumber() == currentAccountNumber){
                return client.getClientBalance();
            }
        }
        System.out.println( "Invalid Account Number" );
        return -1;       
    }

    private void updateBalance(int currentAccountNumber, double newBalance) {
        client client = clientsAccounts.get(currentAccountNumber);
        if  (client != null) {
           client.setClientBalance(newBalance);
        } 
    }

    public int getAccountNumber(int accountNumber) {
        client client = clientsAccounts.get(accountNumber);
        if (client != null) return client.getAccountNumber();
        return -1;
    }


    public int getPin(int accountNumber) {
        client client = clientsAccounts.get(accountNumber);
        if (client != null) return client.getPin();
        return -1;
    }

    public static boolean verifyAccount(int accountNumber){
        return clientsAccounts.containsKey(accountNumber);
    }

    public static boolean verifyPin(int Pin, int accountNumber){
        client client = clientsAccounts.get(accountNumber);
        return client != null && client.getPin()==Pin;
    }

    @Override
    public double checkBalance() {
        double standingBalance = getBalance(currentAccountNumber);
        System.out.println("Your Balance is R " +standingBalance);
        return standingBalance;
    }


    @Override
    public double deposit(double amount) {
        double currentBalance = getBalance(currentAccountNumber);
        if (amount > 0){
            currentBalance += amount;
            updateBalance(currentAccountNumber, currentBalance);
            System.out.println("Deposited " + amount + ". Current balance is: R " + currentBalance);
            checkBalance();
            return currentBalance;
        }
        System.out.println(amount + " cannot be a less than zero.");
        return currentBalance;
    }


    @Override
    public double withdrawal(double amount) {
        double currentBalance = getBalance(currentAccountNumber);
        if (amount <= currentBalance){
            currentBalance -= amount;
            updateBalance(currentAccountNumber, currentBalance);
            System.out.println("Withdrew " + amount + ". Remaining balance is: R " + currentBalance);
            checkBalance();
            return currentBalance;
        }
         System.out.println("Insufficient funds in account. Please try again with a smaller amount.");
        return currentBalance;
        // return 0;
    }
    
}
