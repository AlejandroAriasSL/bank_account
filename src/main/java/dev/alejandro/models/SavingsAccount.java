package dev.alejandro.models;

public class SavingsAccount extends Account {

    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    public boolean isActive() {
        return getBalance() >= 10000.0f;
    }

    @Override
    public void deposit(float amount) {
        if (!isActive()) {
            throw new IllegalArgumentException("Cannot deposit to an inactive account");
        } 
        
        balance += amount;
    }

    @Override
    public void withdraw(float amount) {
        if (!isActive()) {
            throw new IllegalArgumentException("Cannot withdraw from an inactive account");
        }

        balance -= amount;
        withdrawalCounter++;
    }
}
