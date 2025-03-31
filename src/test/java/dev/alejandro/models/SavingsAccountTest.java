package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    private float amount; 

    @BeforeEach
    private void setUp() {
        amount = 1000;
    }
    
    @Test
    @DisplayName("It should return true if balance is equal to or higher than $10000")
    void test_returns_active_status_of_account() {

        float balance = 10000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(balance, annualRate);

        assertThat(savingsAccount.isActive(), is(true));
    }

    @Test
    @DisplayName("It should throw an exception if deposit and account is inactive")
    void test_throws_exception_if_account_is_inactive() {

        float initialBalance = 5000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, annualRate);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> 
            savingsAccount.deposit(amount));
  

        assertFalse(savingsAccount.isActive());
        assertThat(exception.getMessage(), is("Cannot deposit to an inactive account"));

    }

    @Test
    @DisplayName("It should allow deposit if account is active")
    void test_allows_deposit_if_account_is_active() {

        float initialBalance = 10000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, annualRate);

        savingsAccount.deposit(amount);

        assertTrue(savingsAccount.isActive());
        assertThat(savingsAccount.getBalance(), is(initialBalance + amount));
    }

    @Test
    @DisplayName("It should throw an exception if withdraw and account is inactive")
    void test_throws_exception_if_account_is_inactive_and_withdraw() {

        float initialBalance = 5000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, annualRate);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> 
            savingsAccount.withdraw(amount));
  

        assertFalse(savingsAccount.isActive());
        assertThat(exception.getMessage(), is("Cannot withdraw from an inactive account"));
    }

    @Test
    @DisplayName("It should allow withdraw if account is active")
    void test_allows_withdraw_if_account_is_active() {

        float initialBalance = 10000;
        float annualRate = 1;

        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, annualRate);

        assertTrue(savingsAccount.isActive());
        
        savingsAccount.withdraw(amount);
        assertThat(savingsAccount.getBalance(), is(initialBalance - amount));
    }

}
