package dev.alejandro.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    private float balance;
    private float annualRate;
    private CurrentAccount currentAccount;

    @BeforeEach
    private void setUp() {

        balance = 20000;
        annualRate = 1;

        currentAccount = new CurrentAccount(balance, annualRate);
    }

    @Test
    @DisplayName("It should have an attribute 'overdraft' initialized to 0")
    void test_overdraft_initialzes_to_0() {

        assertThat(currentAccount.getOverdraft(), is(0.0f));
    }

    @Test
    @DisplayName("It should accumulate debt as overdraft")
    void test_it_accumulates_debt_as_overdraft() {

        float amount = 30000;

        currentAccount.withdraw(amount);

        float expectedOverdraft = amount - balance;

        assertThat(currentAccount.getOverdraft(), is(expectedOverdraft));
    }

    @Test
    @DisplayName("It should reduce the overdraft when deposit are done if there is overdraft")
    void test_deposit_reduces_overdraft() {

        float amount = 30000;

        currentAccount.withdraw(amount);

        float expectedOverdraft = amount - balance;

        assertThat(currentAccount.getOverdraft(), is(expectedOverdraft));

        float depositAmount = 5000;

        currentAccount.deposit(depositAmount);

        assertThat(currentAccount.getOverdraft(), is(expectedOverdraft - depositAmount));

    }

    @Test
    @DisplayName("It should print the balance, monthly commision, number of transactions and overdraft value")
    void test_prints_attributes_of_the_current_account() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        float amount = 30000;

        currentAccount.withdraw(amount);

        currentAccount.printDetails();

        String outputString = output.toString();
        
        assertThat(outputString, containsString(String.valueOf(currentAccount.getOverdraft())));
        
        System.setOut(originalOut);
    }
}
