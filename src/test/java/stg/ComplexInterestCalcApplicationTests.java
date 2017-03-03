package stg;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import stg.account.Account;
import stg.transaction.RecurringTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexInterestCalcApplicationTests {
    InterestCalculator interestCalculator = new InterestCalculator();

    @Test
    public void contextLoads() {
    }

    @Test
    //complex interest w/ normal balance (non-zero, no RMB)
    public void normalBalanceNonZeroNoRMB(){}

    @Test
    //complex interest w/ normal balance (non-zero, above RMb)
    public void normalBalanceNonZeroAboveRMB(){}

    @Test
    //complex interest below minimum balance (non-zero)
    public void belowMinimumBalance(){}

    @Test
    //complex interest w/ zero balance (no RMB)
    public void zeroBalanceNoRMB(){}

    @Test
    //complex interest w/ zero balance (above RMB)
    public void zeroBalanceAboveRMB(){}

    @Test
    //complex interest w/ negative balance (no RMB)
    public void negativeBalanceNoRMB(){}

    @Test
    //complex interest w/ negative balance (above RMB)
    public void negativeBalanceAboveRMB(){}

    @Test
    //complex interest w/ normal balance recurring deductions will exceed interest earned
    public void normalBalanceRecurringDeductionsExceedInterest(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, -200);
        account.setBalance(1000);
        account.setInterestRate(0.01);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account,1,1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest w/ normal balance recurring decutions will not exceed interest earned
    public void normalBalanceRecurringDeductionsWillNotExceedInterest(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, -50);
        account.setBalance(1000);
        account.setInterestRate(0.01);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 1, 1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest below RMB recurring contributions will not bring account above RMB
    public void belowRMBRecurringContributionsNotBringAboveRMB(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, 100);
        account.setBalance(100);
        account.setInterestRate(0.01);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(500);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 1,1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest below RMB recurring contributions will bring above RMB
    public void belowRMBRecurringContributionsWIillBringAboveRMB(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, 400);
        account.setBalance(400);
        account.setInterestRate(0.01);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(500);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 1, 1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest low balance become overdrawn w/ recurring contributions will bring above $0
    public void lowBalanceOverdrawnRecurringContributionsBringAboveZero(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, -200);
        RecurringTransaction recurringTransaction1 = new RecurringTransaction(1, 500);
        account.setBalance(100);
        account.setInterestRate(0.01);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account,1,1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest low balance become overdrawn w/ recurring contributions will not bring above $0
    public void lowBalanceOverdrawnRecurringCOntributionsWillNotBringAboveZero(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, 200);
        RecurringTransaction recurringTransaction1 = new RecurringTransaction(1, -500);
        account.setBalance(100);
        account.setInterestRate(0.01);
        double expected =0;
        double actual = interestCalculator.calculateComplexInterest(account,1,1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest overdrawn account recurring contributions will not bring above $0
    public void overdrawnRecurringContributionsWillNotBringAboveZero(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1,100);
        account.setBalance(-1000);
        account.setInterestRate(0.01);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 1,1);
        assertEquals("test", expected, actual);
    }

    @Test
    //complex interest overdrawn account recurring contributions will bring above $0
    public void overdrawnRecurringContributionsBringAboveZero(){
        Account account = new Account();
        RecurringTransaction recurringTransaction = new RecurringTransaction(1, 1000);
        account.setBalance(-100);
        account.setInterestRate(0.01);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account,1,1);
        assertEquals("test", expected,actual);
    }




}
