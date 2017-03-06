package stg;

import org.springframework.web.bind.annotation.*;
import stg.account.Account;
import stg.ledger.Ledger;
import stg.transaction.RecurringTransaction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michaelwolfe on 3/3/17.
 */
@RestController
public class Controller {

    @CrossOrigin
    @RequestMapping(value = "/simpleInterestCalculator", method = RequestMethod.POST, consumes = {"application/json"})
    public
    @ResponseBody
    long getSimpleInterest(@RequestBody Account account) {
        InterestCalculator ic = new InterestCalculator();
        return ic.calculateSimpleInterest(account, account.getInterval());
    }

    @CrossOrigin
    @RequestMapping(value = "/compoundInterestCalculator", method = RequestMethod.POST, consumes = {"application/json"})
    public
    @ResponseBody
    long getCompoundInterest(@RequestBody Account account) {
        InterestCalculator ic = new InterestCalculator();
        return ic.calculateComplexInterest(account, account.getInterval(), account.getPeriod());
    }

    @CrossOrigin
    @RequestMapping(value = "/account", method = RequestMethod.POST, consumes = {"application/json"})
    public
    @ResponseBody
    Account getAccount(@RequestBody Account account) {

    }

    @CrossOrigin
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST, consumes = {"application/json"})
    public
    @ResponseBody
    void addAccount(@RequestBody Account account) {

    }

    @CrossOrigin
    @RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = {"application/json"})
    public
    @ResponseBody
    void addRecurringTransactions(@RequestBody Ledger ledger) {

    }
}
