package stg.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stg.model.account.Account;
import stg.repository.account.AccountRepository;

/**
 * Created by rickjackson on 3/6/17.
 */
@RestController
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public @ResponseBody Account createAccount(
            @RequestParam(value = "number", required = true)
            String number,
            @RequestParam(value = "accountType", required = true)
            String accountType,
            @RequestParam(value = "balance", required = true)
            long balance,
            @RequestParam(value = "interestRate", required = true)
            double interestRate,
            @RequestParam(value = "requiredMinimumBalance", required = true)
            long requiredMinimumBalance,
            @RequestParam(value = "isMinimumBalanceRequired", required = true)
            boolean isMinimumBalanceRequired) {
        Account account = new Account(number, accountType, balance,
                                      interestRate, requiredMinimumBalance,
                                      isMinimumBalanceRequired);
        accountRepository.save(account);
        return account;
    }
}
