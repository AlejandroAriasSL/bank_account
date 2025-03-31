package dev.alejandro;

public abstract class Account {
    
    protected float balance;

    protected Account(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

}
