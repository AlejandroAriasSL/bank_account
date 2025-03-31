package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
