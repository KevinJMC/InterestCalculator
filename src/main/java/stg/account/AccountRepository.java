package stg.account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ryan on 3/5/17.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query
    Account findAccountByAccountNumber(double accountNumber);

}
