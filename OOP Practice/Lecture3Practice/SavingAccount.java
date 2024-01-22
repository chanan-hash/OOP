package Lecture3Practice;

import java.util.ArrayList;
import java.util.List;

public class SavingAccount implements Account{

    private List<Double> transactions;

    public SavingAccount() {
        transactions = new ArrayList<Double>();
    }

    @Override
    public void deposit(double amount) {
        transactions.add(amount);
    }

    @Override
    public double withdraw(double amount) {
        transactions.add(-amount);
        return -amount; // How much we've withdrawn
    }

    // Total amount deposited minus total amount withdrawn
    @Override
    public double getBalance() {
        double balance = 0;
        for (double t : transactions) {
            balance += t;
        }
        return balance;
    }

    @Override
    public String getDescription() {
        return "Saving Account";
    }

    public void addInterest(double rate) {
        double interest = getBalance() * rate / 100;
        deposit(interest);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    // Unique method to SavingAccount
    // We can transfer money from saving account to other account, that why we're getting the interface Account
    public void transferOne(double amount, Account other) {
        other.withdraw(amount);
        deposit(amount);
    }

    public void transferAll(Account other) {
        double amount = other.getBalance();
        other.withdraw(amount);
        deposit(amount);
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Double> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "transactions=" + transactions +
                '}';
    }
}
