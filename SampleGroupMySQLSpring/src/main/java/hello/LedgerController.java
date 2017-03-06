package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController    // This means that this class is a RecurringTransactionsController
@RequestMapping(path = "/database") // This means URL's start with /demo (after Application path)
public class LedgerController {
    @Autowired
    private LedgerRepository ledgerRepository;

    @PostMapping(path = "Ledger/add", consumes = "application/json")
    public
    String addLedger(@RequestBody Ledger ledger) {
        ledgerRepository.save(ledger);
        return "Saved";
    }

//    @RequestMapping(value = "Ledger/{ID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public
//    Ledger findLedgerByLedgerID(@PathVariable long ID) {
//        Ledger ledger = ledgerRepository.findLedgerByID(ID);
//        return ledger;
//    }

    @RequestMapping(value = "Ledger/transactionNumber{transactionNumber}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    Ledger findLedgerByTransactionNumber(@PathVariable long transactionNumber) {
        Ledger ledger = ledgerRepository.findLedgerByTransactionNumber(transactionNumber);
        return ledger;
    }

    @RequestMapping(value = "Ledger/accountID{Account_ID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    Ledger findLedgerByAccount_ID(@PathVariable long Account_ID) {
        Ledger ledger = ledgerRepository.findLedgerByAccountID(Account_ID);
        return ledger;
    }


//    @GetMapping(path = "/add") // Map ONLY GET Requests
//    public
//    @ResponseBody
//    String addNewLedger(@RequestParam long transactionNumber, @RequestParam String description, @RequestParam double debit, @RequestParam double credit) {
//        Ledger ledger = new Ledger();
//        ledger.setTransactionNumber(transactionNumber);
//        ledger.setDescription(description);
//        ledger.setDebit(debit);
//        ledger.setCredit(credit);
//        ledgerRepository.save(ledger);
//        return "saved";
//    }
//
//    @GetMapping(path = "/all")
//    public
//    @ResponseBody
//    Iterable<Ledger> getAllLedgersTransactions() {
//        // This returns a JSON or XML with the RecurringTransactionsController
//        return ledgerRepository.findAll();
//    }
//
//    @GetMapping(path = "/one")
//    public
//    @ResponseBody
//    Ledger findLedgerByID(@PathVariable("ID") long id) {
//        return ledgerRepository.findOne(id);
//    }
}
