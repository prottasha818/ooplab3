import java.util.*;

abstract class Account {
    protected String accountName;
    protected double balance;
    protected String ID;
    protected String accType;

    public Account() {}

    public Account(String accountName, String ID, double balance, String accType) {
        this.accountName = accountName;
        this.ID = ID;
        this.balance = balance;
        this.accType = accType;
    }

    public double credit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public double debit(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    public double transferTo(double amount, Account destination) {
        if (amount <= balance) {
            this.debit(amount);
            destination.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public double interest(double balance) {
        return balance;
    }

    public String toString() {
        return "Account [ID: " + this.ID + ", Name: " + this.accountName + ", Balance: " + this.balance + "]";
    }
}
