package account;

import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }
    
    public Account(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        this.dateCreated = new Date();
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
        Account.annualInterestRate = annualInterestRate;
    }
    
    public Date getDateCreated(){
       return dateCreated;
    }
   
    public double getMonthlyInterestRate(){
       return annualInterestRate/12;
    }
   
    public double getMonthlyInterest(){
       return balance * this.getMonthlyInterestRate();
    }
    
    public void withdraw(double amount){
        balance-=amount;
    }
    
    public void deposit(double amount){
        balance+=amount;
    }
    
    public static void main(String[] args) {
        Account a = new Account(1122, 20000);
        Account.setAnnualInterestRate(0.045);
        a.withdraw(2500);
        a.deposit(3000);
        System.out.println("Balance: " + a.getBalance());
        System.out.println("Monthly Interest: " + a.getMonthlyInterest());
        System.out.println("Date Created: " + a.getDateCreated());
    }
    
}
