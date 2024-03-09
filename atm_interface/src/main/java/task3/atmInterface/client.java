package task3.atmInterface;
// package 
public class client {
    private int serialNumber;
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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
    public client(int serialNumber, int Pin, double clientBalance){
        this.serialNumber = serialNumber;
        this.Pin = Pin;
        this.clientBalance = clientBalance;
    }

    
    
}
