package stg.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ryan on 3/5/17.
 */

@RestController
@RequestMapping(path="/")

public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping(path="/accounts/add", consumes = "application/json")
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }
}
