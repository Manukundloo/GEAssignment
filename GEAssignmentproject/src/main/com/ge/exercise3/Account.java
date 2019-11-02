package main.com.ge.exercise3;

import java.security.InvalidParameterException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {

	// We have to compare string is the code using equals keyword
	private static final Logger logger = LogManager.getLogger(Account.class);

	// No need static variable
	/*
	 * private static float monthlyInterestRate = 1.01f; 
	 * private static float monthlyFee = 0.0f;
	 */

	private float monthlyInterestRate = 1.01f;
	private float monthlyFee = 0.0f;

	private String accountNumber;
	private String accountType;
	private float balance;

	// It better to create final variable for output comments
	private static final String noFeeCheckingAccount = "No fee checking account #";
	private static final String checkingAccount = "Checking account #";
	private static final String highInterestForNoFeeSavingAcc = "High interest no fee savings account #";
	private static final String highInterestSavingAcc = "High interest savings account #";
	private static final String noFeeSavingsAcc = "No fee savings account #";
	private static final String savingsAcc = "Savings account #";
	private static final String checkingWithdranAmount = "You can't withdraw ammount more than 100 from the Checking Account";

	// Here we can call constructor in reverse order like this

	public Account(String accountNumber) {
		// The commented line is not required
		// new Account(accountNumber, "Savings", 0.0f);
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber, String accountType) {

		// Commented code is not required better we call this for calling the
		// constructor
		// new Account(accountNumber, accountType, 0.0f);
		this(accountNumber);
		this.accountType = accountType;
	}

	public Account(String accountNumber, String accountType, float balance) {

		// Commented code is not required better we call this for calling the
		// constructor

		/*
		 * this.accountNumber = accountNumber; this.accountType = accountType;
		 */

		this(accountNumber, accountType);
		this.balance = balance;

		// here it should use equals method

		// if (accountType == "Checking") { monthlyInterestRate = 1.0f; }

		if (accountType.equals("Checking")) {
			monthlyInterestRate = 1.0f;
		}

	}

	public float valueNextMonth() {

		return (balance * monthlyInterestRate) - monthlyFee;
	}

	@Override
	public String toString() {
		// need to compare using equals/equalIgnoreCase keyword
		// if (accountType == "Checking") {

		// Create one String variable for returning the output
		String result = "";

		if (accountType.equals("Checking")) {
			if (monthlyFee == 0.0f) {
				// return "No fee checking account #" + accountNumber;
				result = noFeeCheckingAccount + accountNumber;
			} else {
				// return "Checking account #" + accountNumber;
				result = checkingAccount + accountNumber;
			}
		} else {
			if (monthlyInterestRate > 1.01) {
				if (monthlyFee == 0.0f) {
					// return "High interest no fee savings account #" +
					// accountNumber;
					result = highInterestForNoFeeSavingAcc + accountNumber;
				} else {
					// return "High interest savings account #" + accountNumber;
					result = highInterestSavingAcc + accountNumber;
				}
			} else {
				if (monthlyFee == 0.0f) {
					// return "No fee savings account #" + accountNumber;
					result = noFeeSavingsAcc + accountNumber;
				} else {
					// return "Savings account #" + accountNumber;
					result = savingsAcc + accountNumber;
				}
			}
		}
		return result;
	}

	public void deposit(float amount) {
		balance += amount;
	}

	// better return the float value
	// public void withdraw(float amount) {
	public float withdraw(float amount) {		
		if(accountType.equals("Checking") && (amount > 100.0f)){
			throw new InvalidParameterException("Can't withdraw Amount more than $100");
			
		}else if(accountType.equals("Savings")&&(amount >balance)){
			throw new InvalidParameterException("Can't withdraw Amount more than the current balance");			
		}
		return balance -= amount;
	}

	
	public float getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(float monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public float getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(float monthlyFee) {

		this.monthlyFee = monthlyFee;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
