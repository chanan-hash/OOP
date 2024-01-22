package Lecture3Practice;

public interface Account {
    public void deposit(double amount);
    public double withdraw(double amount);
    public double getBalance();
    public String getDescription();

    public double calculateInterest();
}
