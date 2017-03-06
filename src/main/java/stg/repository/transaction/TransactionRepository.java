package stg.repository.transaction;

import org.springframework.data.repository.CrudRepository;
import stg.model.transaction.Transaction;

/**
 * Created by rickjackson on 3/6/17.
 */
public interface TransactionRepository extends CrudRepository<Transaction,
                                                                     Long> {
}
