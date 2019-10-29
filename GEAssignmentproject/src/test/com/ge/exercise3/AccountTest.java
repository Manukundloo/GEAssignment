package test.com.ge.exercise3;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import main.com.ge.exercise3.Account;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    Account checkingAccount;
    Account savingsAccount;

    @Before
    public void setUp() {
        checkingAccount = new Account("001", "Checking");
        savingsAccount = new Account("002", "Savings");
    }

    @Test
    public void depositAndWithdrawTest() {
        checkingAccount.setBalance(0.0f);
        checkingAccount.deposit(100.0f);
        assertEquals(100.0f, checkingAccount.getBalance(), 0.01);
        checkingAccount.withdraw(100.0f);
        assertEquals(0.0f, checkingAccount.getBalance(), 0.01);
    }
    
    // Added new test case for withdraw amount more than $100 as CheckingAccount 
    @Test(expected=InvalidParameterException.class)
    public void withdrawAmountmoreThanTheLimitTest() {
        assertEquals("Can't withdraw Amount more than $100", checkingAccount.withdraw(102.0f));
    }

    // Added new test case for withdraw amount more than the balance from SavingsAccount 
    @Test(expected=InvalidParameterException.class)
    public void withdrawAmountmoreThanTheBalanceFromSavingsAccountTest() {
    	savingsAccount.setBalance(153.0f);
        assertEquals("Can't withdraw Amount more than the current balance", savingsAccount.withdraw(198.0f));
    }
    @Test
    public void valueNextMonthTest() {
        checkingAccount = new Account("003", "Checking", 100.0f);
        assertEquals(100.0f, checkingAccount.valueNextMonth(), 0.01f);

        savingsAccount = new Account("004", "Savings", 100.0f);
        assertEquals(101.0f, savingsAccount.valueNextMonth(), 0.01f);

        checkingAccount.setMonthlyFee(10.0f);
        assertEquals(90.0f, checkingAccount.valueNextMonth(), 0.01f);

        savingsAccount.setMonthlyInterestRate(1.05f);
        assertEquals(105.0f, savingsAccount.valueNextMonth(), 0.01f);
    }

    @Test
    public void toStringTest() {
        savingsAccount = new Account("005", "Savings", 0.0f);
        assertEquals("No fee savings account #005", savingsAccount.toString());

        checkingAccount = new Account("006", "Checking", 0.0f);
        assertEquals("No fee checking account #006", checkingAccount.toString());

        checkingAccount.setMonthlyFee(10.0f);
        assertEquals("Checking account #006", checkingAccount.toString());

        savingsAccount.setMonthlyInterestRate(1.02f);
        //Need to set the Monthly Fee value to execute the test
        savingsAccount.setMonthlyFee(0.0f);
        assertEquals("High interest no fee savings account #005", savingsAccount.toString());
    }
}