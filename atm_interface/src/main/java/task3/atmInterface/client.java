package task3.atmInterface;
// package 
public class client {
    private int accountNumber;
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    private int Pin;
    public int getPin() {
        return Pin;
    }

    private double clientBalance;

    public double getClientBalance() {
        return clientBalance;
    }

    public void setClientBalance(double clientBalance) {
        this.clientBalance = clientBalance;
    }

    // create a constructor for the client 
    public client(int accountNumber, int Pin, double clientBalance){
        this.accountNumber = accountNumber;
        this.Pin = Pin;
        this.clientBalance = clientBalance;
    }

    
    
}
