package dev.alejandro;

public abstract class Account {
    
    protected float balance, annualRate;

    protected Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public float getBalance() {
        return balance;
    }

    public float getAnnualRate() {
        return annualRate;
    }

}
