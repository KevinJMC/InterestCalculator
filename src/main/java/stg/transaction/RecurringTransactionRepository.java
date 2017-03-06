package stg.transaction;

import org.springframework.data.repository.CrudRepository;


/**
 * Created by ryan on 3/5/17.
 */
public interface RecurringTransactionRepository extends CrudRepository<RecurringTransaction,Long> {
}
