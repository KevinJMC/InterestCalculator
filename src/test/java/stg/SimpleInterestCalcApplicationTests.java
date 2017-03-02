package stg;

import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleInterestCalcApplicationTests {
	InterestCalculator interestCalculator = new InterestCalculator();

	@Test
	public void contextLoads() {

	}

	@Test
	//simple interest w/ normal balance (non zero, no RMB)
	public void simpleInterestNormalBalanceTest(){
		Account account = new Account();
		account.setBalance(1000);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(false);
		double expected = 100;
		double actual = interestCalculator.calculateSimpleInterest(account,1);
		assertEquals(expected,actual,1);
	}

	@Test
	//simple interest w/ normal balance (non zero, above RMB)
	public void simpleInterestNormalBalanceAboveRMB(){
		Account account = new Account();
		account.setBalance(1000);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(100);
		double expected = 100;
		double actual = interestCalculator.calculateSimpleInterest(account,1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest below minimum balance (non-zero)
	public void simpleInterestBelowMinBalanceTest(){
		Account account = new Account();
		account.setBalance(100);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(1000);
		double expected = 100;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("Test", expected, actual);
	}

	@Test
	//simple interest w/ zero balance (no RMB)
	public void simpleInterestZeroBalanceNoRMB(){
		Account account = new Account();
		account.setBalance(0);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(false);
		double expected = 100;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest w/ zero balance (above RMB)
	public void simpleInterestZeroBalanceAboveRMB(){
		Account account = new Account();
		account.setBalance(0);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(100);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest w/ negative balance (no RMB)
	public void simpleInterestNegativeBalanceTest(){
		Account account = new Account();
		account.setBalance(-1000);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(false);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest w/ negative balance (below RMB)
	public void simpleInterestNegativeBalanceBelowRMBTest(){
		Account account = new Account();
		account.setBalance(-1000);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(100);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest w/ normal balance, recurring deductions, not exceed interest earned
	public void normalBalanceReoccuringDeductionsNotExceedInterestTest(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, 10);
		account.setBalance(1000);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest w/ normal balance, recurring deductions, exceed interest earned
	public void normalBalanceRecurringDeductionsExceedInterestEarned(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, -200);
		account.setBalance(1000);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest below RMB w/ recurring contributions will not bring account above RMB
	public void belowRmbRecurringContributionsNotAboveRmb(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, 100);
		account.setBalance(100);
		account.setInterestRate(.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(1000);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);

	}

	@Test
	//simple interest below RMB w/ recurring contributions will bring account above RMB
	public void belowRmbReucrringContributionsWillBringAboveRMB(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, 500);
		account.setBalance(900);
		account.setInterestRate(0.01);
		account.setMinimumBalanceRequired(true);
		account.setRequiredMinimumBalance(1000);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest low balance account will overdraw w/ recurring contributions will not bring above $0
	public void lowBalanceAccoutWillOverdrawReucrringContributionsNotBringAboveZero(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, -500);
		RecurringTransaction recurringTransaction1 = new RecurringTransaction(1, 100);
		account.setBalance(100);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account,1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest low balance account will overdraw w recurring contributions will bring above $0
	public void lowBalanceAccountWillOverdrawRecurringTransBringAboveZero(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, -200);
		RecurringTransaction recurringTransaction1 = new RecurringTransaction(1, 500);
		account.setBalance(100);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest overdrawn account with recurring contributions will not bring above $0
	public void overdrawnAccountRecurringTransNotBringAboveZero(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, 100);
		account.setBalance(-1000);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account, 1);
		assertEquals("test", expected, actual);
	}

	@Test
	//simple interest overdrawn account recurring contributions will bring above $0
	public void overdrawnAccountRecurringTransBringAboveZero(){
		Account account = new Account();
		RecurringTransaction recurringTransaction = new RecurringTransaction(1, 500);
		account.setBalance(-100);
		account.setInterestRate(.01);
		double expected = 0;
		double actual = interestCalculator.calculateSimpleInterest(account,1);
		assertEquals("test", expected, actual);
	}




}
