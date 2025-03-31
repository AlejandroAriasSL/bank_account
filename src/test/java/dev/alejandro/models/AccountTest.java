package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.alejandro.Account;

public class AccountTest {

    private class AbstractAccount extends Account {
        private AbstractAccount(float balance, float annualRate) {
            super(balance, annualRate);
        }
    }

    private AbstractAccount account;

    @BeforeEach
    void setUp() {
        account = new AbstractAccount(1000, 1);
    }

    @Test
    @DisplayName("It should return the balance attribute of the account")
    void test_returns_balance_of_account() {

        assertThat(account.getBalance(), is(1000.0f));
    }

    @Test
    @DisplayName("It should return the annualRate attribute of the account")
    void test_returns_annualRate_of_account() {


        assertThat(account.getAnnualRate(), is(1.0f));
    }

    @Test
    @DisplayName("It should return the monthlyCommision attribute of the account")
    void test_returns_monthlyCommision_of_account() {


        assertThat(account.getMonthlyCommision(), is(0.0f));
    }

    @Test
    @DisplayName("It should return the deposit counter of the account")
    void test_returns_depositCoutner_of_account() {
    
    
        assertThat(account.getDepositCounter(), is(0));
    }

    @Test
    @DisplayName("It should return the withdrawal counter of the account")
    void test_returns_withdrawalCounter_of_account() {

        assertThat(account.getWithdrawalCounter(), is(0));
    }

    @Test
    @DisplayName("It should update balance after deposit")
    void test_updates_balance_after_deposit() {

        account.deposit(1000);

        assertThat(account.getBalance(), is(2000.0f));
    }

    @Test
    @DisplayName("It should have a withdraw method that updates the balance of the account")
    void test_it_updates_balance_after_withdraw() {

        account.withdraw(50);

        assertThat(account.getBalance(), is(950.0f));
    }

     @Test
    @DisplayName("It should throw a exception if withdraw amount is higher than balance amount")
    void test_throws_exception_if_withdrawal_is_higher_than_balance() {

        IllegalArgumentException exception = assertThrows(
          IllegalArgumentException.class, () -> 
            account.withdraw(2000));

        assertThat(exception.getMessage(), is("Insufficient funds for this operation."));


    }
}
