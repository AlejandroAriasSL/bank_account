package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("It should throw an exception if deposit is and account is inactive")
    void test_throws_exception_if_account_is_inactive() {

        float initialBalance = 5000;
        float annualRate = 1;
        float depositAmount = 1000;

        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, annualRate);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> 
            savingsAccount.deposit(depositAmount));
  

        assertFalse(savingsAccount.isActive());
        assertThat(exception.getMessage(), is("Cannot deposit to an inactive account"));

    }
}
