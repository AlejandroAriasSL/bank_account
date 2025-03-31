package dev.alejandro;

public abstract class Account {
    
    protected float balance, annualRate, monthlyCommision;

    protected Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.monthlyCommision = 0;
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

}
