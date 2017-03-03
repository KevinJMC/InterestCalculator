package stg;

import org.springframework.web.bind.annotation.RestController;
import stg.account.Account;

@RestController
public class InterestCalculator {

    public long calculateSimpleInterest(Account account, int interval){

        if(account.getOverdrawn())
        return (long) (account.getBalance() * (1 + account.getInterestRate() * interval));
    }

    public long calculateComplexInterest(Account account, int interval, int frequency){


        return (long) (account.getBalance()* Math.pow((1 + account.getInterestRate()
                / frequency), (frequency * interval))) - account.getBalance();

    }
}
