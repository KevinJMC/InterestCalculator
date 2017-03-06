package stg.repository.account;

import org.springframework.data.repository.CrudRepository;
import stg.model.account.Account;

/**
 * Created by rickjackson on 3/6/17.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
