package stg.controller.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stg.exception.InvalidTransactionRequestException;
import stg.exception.TransactionNotFoundException;
import stg.model.transaction.Transaction;
import stg.repository.transaction.TransactionRepository;

import java.time.LocalDateTime;

/**
 * Created by rickjackson on 3/6/17.
 */
@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository repo;
    
    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public @ResponseBody Transaction createTransaction(
            @RequestParam(value = "timestamp", required = true)
                    LocalDateTime timestamp,
            @RequestParam(value = "type", required = true)
                    String type,
            @RequestParam(value = "amount", required = true)
                    long amount) {
        Transaction transaction = new Transaction(timestamp, type, amount);
        repo.save(transaction);
        return transaction;
    }
    
    @RequestMapping(value = "/transaction/{transactionId}",
                    method = RequestMethod.POST)
    public Transaction getTransaction(@PathVariable("transactionId")
                                      Long transactionId) {
        if (transactionId == null) {
            throw new InvalidTransactionRequestException();
        }
        Transaction transaction = repo.findOne(transactionId);
        
        if (transaction == null) {
            throw new TransactionNotFoundException();
        }
        return transaction;
    }
}
