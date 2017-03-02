package stg;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kevinmccann on 3/1/17.
 */
@RestController
public class InterestCalculator {
    long calculateSimpleInterest(Account account, int interval) {
        return account.getBalance() * interval * account.getInterestRate();
    }

    long calculateComplexInterest(Account account, int interval, int frequency) {}
}
