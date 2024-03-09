package task3.atmInterface;

public interface atm {

    double withdrawal(double amount);
    double deposit(double amount);
    double checkBalance();
}