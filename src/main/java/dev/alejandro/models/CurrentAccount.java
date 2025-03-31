package dev.alejandro.models;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.overdraft = 0;
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(float amount){
        if (amount > balance) {
            overdraft += amount - balance;
            balance = 0;
        } else {
            super.withdraw(amount);
        }
    }
}
