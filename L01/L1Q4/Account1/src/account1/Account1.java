package account1;

import java.util.ArrayList;
import java.util.Date;

public class Account1 {

    private String name;
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account1() {
        this.dateCreated = new Date();
    }

    public Account1(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        this.dateCreated = new Date();
    }

    public Account1(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account1.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * this.getMonthlyInterestRate();
    }

    public void withdraw(double amount, String description) {
        this.balance -= amount;
        transactions.add(new Transaction('W', amount, this.balance, description));
    }

    public void deposit(double amount, String description) {
        balance += amount;
        transactions.add(new Transaction('D', amount, this.balance, description));
    }

    public static void main(String[] args) {
        Account1 a = new Account1("George", 1122, 1000);
        Account1.setAnnualInterestRate(0.015);
        a.deposit(30, "1st deposit");
        a.deposit(40, "2nd deposit");
        a.deposit(50, "3rd deposit");
        a.withdraw(5, "1st withdraw");
        a.withdraw(4, "2nd withdraw");
        a.withdraw(2, "3rd withdraw");

        System.out.println("Account summary: ");
        System.out.println("Account holder: " + a.getName());
        System.out.println("Interest rate: " + a.getAnnualInterestRate());
        System.out.println("Balance: " + a.getBalance() + "\n");
        System.out.println("Transactions:");

        for (Transaction transaction : a.getTransactions()) {
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Balance: " + transaction.getBalance());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println();
        }
    }
}
