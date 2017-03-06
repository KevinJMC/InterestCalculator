package hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/database")
public class RecurringTransactionsController {

	@Autowired
	RecurringTransactionsRepository recurringTransactionsRepository;

	@PostMapping(path = "RecurringTransactions/add", consumes = "application/json")
	public String addRecurringTransaction(@RequestBody RecurringTransactions recurringTransactions) {
		recurringTransactionsRepository.save(recurringTransactions);
		return "Saved";
	}

//	@RequestMapping(value = "RecurringTransactions/{ID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public RecurringTransactions findRecurringTransactionByRecurringTransactionID(@PathVariable long ID) {
//		RecurringTransactions recurringTransactions = recurringTransactionsRepository.findRecurringTransactionsByID(ID);
//		return recurringTransactions;
//	}

	@RequestMapping(value = "RecurringTransactions/{Account_ID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RecurringTransactions findLedgerByAccount_ID(@PathVariable long Account_ID) {
		RecurringTransactions recurringTransactions = recurringTransactionsRepository.findRecurringTransactionsByAccount_ID(Account_ID);
		return recurringTransactions;
	}
}


//	@GetMapping(path = "/add") // Map ONLY GET Requests
//	public
//	@ResponseBody
//	String addNewRecurringTransactions(@RequestParam long frequency, @RequestParam String description, @RequestParam double amount) {
//		RecurringTransactions recurringTransactions = new RecurringTransactions();
//		recurringTransactions.setFrequency(frequency);
//		recurringTransactions.setDescription(description);
//		recurringTransactions.setAmount(amount);
//		recurringTransactionsRepository.save(recurringTransactions);
//		return "saved";
//	}
//
//	@GetMapping(path = "/all")
//	public
//	@ResponseBody
//	Iterable<RecurringTransactions> getAllRecurringTransactions() {
//		// This returns a JSON or XML with the RecurringTransactionsController
//		return recurringTransactionsRepository.findAll();
//	}
//
//	@GetMapping(path = "/one")
//	public
//	@ResponseBody
//	RecurringTransactions findRecurringTransactionByID(@PathVariable("ID") long id) {
//		return recurringTransactionsRepository.findOne(id);
//	}


