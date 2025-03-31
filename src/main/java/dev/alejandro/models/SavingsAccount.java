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
            return;
        }
    }
}
