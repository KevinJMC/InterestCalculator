package stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import stg.account.Account;
import stg.account.AccountRepository;
import stg.transaction.RecurringTransaction;
import stg.transaction.RecurringTransactionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelwolfe on 3/3/17.
 */
@RestController
@RequestMapping(path="/")
public class Controller {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RecurringTransactionRepository recurringTransactionRepository;

    @PostMapping(path = "/add", consumes = "application/json")
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }

    @PostMapping(path = "/{accountNumber}")
    public Account getAccount(@PathVariable double accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber);
    }

    @PostMapping(path ="/{accountNumber}/transactions", consumes = "application/json")
    public void addRecurringTransactionsToAccount(@PathVariable long accountNumber, @RequestBody ArrayList<RecurringTransaction> list) {

        for(RecurringTransaction transaction : list) {
            transaction.setAccountNumber(accountNumber);
            recurringTransactionRepository.save(transaction);
        }
    }


}