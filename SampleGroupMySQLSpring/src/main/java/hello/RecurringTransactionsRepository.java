package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RecurringTransactionsRepository extends CrudRepository<RecurringTransactions, Long> {

    @Query
    public RecurringTransactions findRecurringTransactionsByAccount_ID(long account_ID);

//    @Query
//    public RecurringTransactions findRecurringTransactionsByID(long ID);
}
