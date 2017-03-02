package stg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexInterestCalcApplicationTests {

    InterestCalculator interestCalculator = new InterestCalculator();

    @Test
    public void contextLoads() {
    }

    @Test
    //complex interest w/ normal balance (non-zero, no RMB)
    public void normalBalanceNonZeroNoRMB(){
        Account account = new Account();
        account.setBalance(1000);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(false);
        double expected = 100;
        double actual = interestCalculator.calculateSimpleInterest(account,1);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ normal balance (non-zero, above RMb)
    public void normalBalanceNonZeroAboveRMB(){
        Account account = new Account();
        account.setBalance(1000);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(200);
        double expected = 100;
        double actual = interestCalculator.calculateComplexInterest(account, 1,1);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest below minimum balance (non-zero)
    public void belowMinimumBalance(){
        Account account = new Account();
        account.setBalance(1000);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(1200);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 1,1);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ zero balance (no RMB)
    public void zeroBalanceNoRMB(){
        Account account = new Account();
        account.setBalance(1000);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(false);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 10,3);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ zero balance (above RMB)
    public void zeroBalanceAboveRMB(){
        Account account = new Account();
        account.setBalance(0);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(-100);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 10,3);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ negative balance (no RMB)
    public void negativeBalanceNoRMB(){
        Account account = new Account();
        account.setBalance(-100);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(false);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 10,3);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ negative balance (above RMB)
    public void negativeBalanceAboveRMB(){
        Account account = new Account();
        account.setBalance(-100);
        account.setInterestRate(.1);
        account.setMinimumBalanceRequired(true);
        account.setRequiredMinimumBalance(-200);
        double expected = 0;
        double actual = interestCalculator.calculateComplexInterest(account, 10,3);
        assertEquals(expected,actual,.001);
    }

    @Test
    //complex interest w/ normal balance recurring deductions will exceed interest earned
    public void normalBalanceRecurringDeductionsExceedInterest(){}

    @Test
    //complex interest w/ normal balance recurring decutions will not exceed interest earned
    public void normalBalanceRecurringDeductionsWillNotExceedInterest(){}

    @Test
    //complex interest below RMB recurring contributions will not bring account above RMB
    public void belowRMBRecurringContributionsNotBringAboveRMB(){}

    @Test
    //complex interest below RMB recurring contributions will bring above RMB
    public void belowRMBRecurringContributionsWIillBringAboveRMB(){}

    @Test
    //complex interest low balance become overdrawn w/ recurring contributions will bring above $0
    public void lowBalanceOverdrawnRecurringContributionsBringAboveZero(){}

    @Test
    //complex interest low balance become overdrawn w/ recurring contributions will not bring above $0
    public void lowBalanceOverdrawnRecurringCOntributionsWillNotBringAboveZero(){}

    @Test
    //complex interest overdrawn account recurring contributions will not bring above $0
    public void overdrawnRecurringContributionsWillNotBringAboveZero(){}

    @Test
    //complex interest overdrawn account recurring transactions will bring above $0
    public void overdrawnRecurringContributionsBringAboveZero(){}




}
