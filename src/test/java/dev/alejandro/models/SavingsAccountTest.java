package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    
    @Test
    @DisplayName("It should return true if balance is equal to or higher than $10000")
    void test_returns_active_status_of_account() {

        float balance = 10000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(balance, annualRate);

        assertThat(savingsAccount.isActive(), is(true));
    }
}
