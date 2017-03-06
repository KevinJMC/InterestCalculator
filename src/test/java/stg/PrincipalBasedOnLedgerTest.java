package stg;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by andykim on 3/2/17.
 */
public class PrincipalBasedOnLedgerTest {
    
    PrincipalBasedOnLedger principalBasedOnLedger;
    
    @Before
    public void setUp() {
        principalBasedOnLedger = new PrincipalBasedOnLedger();
    }
    
    @Test
    public void getAvgPrincipleTest() {
        ArrayList<Integer> ledger = new ArrayList<>();
        ledger.add(100);
        ledger.add(300);
        ledger.add(400);
        ledger.add(200);
        ledger.add(600);
        Integer expected = 320;
        Integer actual = principalBasedOnLedger.getAveragePrinciple(ledger, 5);
        assertEquals(actual, expected);
    }
    
    @Test
    public void getMaxPrincipleOverPeriod() {
        ArrayList<Long> ledger = new ArrayList<>();
        ledger.add((long) 200);
        ledger.add((long) 800);
        ledger.add((long) 600);
        ledger.add((long) 400);
        
        Long actual = principalBasedOnLedger.returnMaxPrinciples(ledger, 3);
        Long expected = (long) 800;
        assertEquals(expected, actual);
    }
    
    @Test
    public void getMinPrincipleOverPeriod() {
        ArrayList<Long> ledger = new ArrayList<>();
        ledger.add((long) 200);
        ledger.add((long) 300);
        ledger.add((long) 600);
        Long actual = principalBasedOnLedger.returnMinPrinciples(ledger, 3);
        Long expected = (long) 200;
        assertEquals(expected, actual);
    }
    
    @Test
    public void returnMinBalanceOverNumberOfDay() {
        
        ArrayList<Long> ledger = new ArrayList<>();
        ledger.add((long) 200);
        ledger.add((long) 200);
        ledger.add((long) 200);
        ledger.add((long) 100);
        ledger.add((long) 100);
        ledger.add((long) 300);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 600);
        
        long actual = principalBasedOnLedger.returnMinBalanceOverNumberOfDay(
                ledger,
                7);
        long expected = 600;
        assertEquals(expected, actual);
    }
    
    @Test
    public void returnMaxBalanceOverNumberOfDay() {
        
        ArrayList<Long> ledger = new ArrayList<>();

        ledger.add((long) 200);
        ledger.add((long) 200);
        ledger.add((long) 200);
        ledger.add((long) 100);
        ledger.add((long) 100);
        ledger.add((long) 800);
        ledger.add((long) 800);
        ledger.add((long) 300);
        ledger.add((long) 600);
        ledger.add((long) 600);
        ledger.add((long) 700);
        ledger.add((long) 700);
        
        long actual = principalBasedOnLedger.returnMaxBalanceOverNumberOfDay(
                ledger,
                2);
        long expected = 800;
        assertEquals(expected, actual);
    }
}
