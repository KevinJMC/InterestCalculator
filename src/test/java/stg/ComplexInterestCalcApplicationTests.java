package stg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexInterestCalcApplicationTests {

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
