package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.alejandro.Account;

public class AccountTest {

    private class AbstractAccount extends Account {
        private AbstractAccount(float balance) {
            super(balance);
        }
    }

    @Test
    @DisplayName("It should return the balance attribute of the account")
    void test_returns_balance_of_account() {

        AbstractAccount account = new AbstractAccount(1000);

        assertThat(account.getBalance(), is(1000.0f));
    }
}
