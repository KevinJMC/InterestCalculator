package stg.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stg.exception.AccountNotFoundException;
import stg.exception.InvalidAccountRequestException;
import stg.model.account.Account;
import stg.repository.account.AccountRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    
    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("accountId") Long accountId) {
        if (accountId == null) {
            throw new InvalidAccountRequestException();
        }
        Account account = accountRepository.findOne(accountId);
        
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }
    
    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return (List<Account>) accountRepository.findAll();
    }
    
    @RequestMapping(value = "/account/{accountId}",
                    method = RequestMethod.DELETE)
    public void removeAccount(@PathVariable("accountId") long accountId,
                              HttpServletResponse httpResponse) {
        if (accountRepository.exists(accountId)) {
            Account account = accountRepository.findOne(accountId);
            accountRepository.delete(account);
        }
        httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
