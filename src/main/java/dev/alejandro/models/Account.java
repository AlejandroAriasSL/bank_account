package dev.alejandro.models;

public abstract class Account {
    
    protected float balance, annualRate, monthlyCommision;
    protected int depositCounter, withdrawalCounter;

    protected Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.monthlyCommision = 0;
        this.depositCounter = 0;
        this.withdrawalCounter = 0;
    }

    public float getBalance() {
        return balance;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public float getMonthlyCommision() {
        return monthlyCommision;
    }

    public int getDepositCounter() {
        return depositCounter;
    }

    public int getWithdrawalCounter() {
        return withdrawalCounter;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for this operation.");
        } else {
            balance -= amount;
            withdrawalCounter++;
        }
    }

    public void calculateMonthlyRate() {
        float monthlyRate = (annualRate / 100) / 12;
        balance += balance * monthlyRate;
    }

    public void monthlyStatement() {
        balance -= monthlyCommision;

        calculateMonthlyRate();
    }

    public void printDetails() {
       System.out.println("Account details:"); 
       System.out.println(getBalance()); 
       System.out.println(getAnnualRate()); 
       System.out.println(getMonthlyCommision()); 
       System.out.println(getDepositCounter()); 
       System.out.println(getWithdrawalCounter()); 
    }

}
