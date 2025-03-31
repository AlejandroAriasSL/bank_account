package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    
    @Test
    @DisplayName("It should have an attribute 'overdraft' initialized to 0")
    void test_overdraft_initialzes_to_0() {

        float balance = 20000;
        float annualRate = 1; 

        CurrentAccount currentAccount = new CurrentAccount(balance, annualRate);

        assertThat(currentAccount.getOverdraft(), is(0.0f));
    }

    @Test
    @DisplayName("It should be able to withdraw amounts higher than balance")
    void test_can_withdraw_amount_higher_than_balance() {

        float balance = 20000;
        float annualRate = 1; 
        float amount = 30000;

        CurrentAccount currentAccount = new CurrentAccount(balance, annualRate);

        currentAccount.withdraw(amount);

        assertThat(currentAccount.getBalance(), is(balance - amount));
    }
}
