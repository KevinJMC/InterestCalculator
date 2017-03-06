package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LedgerRepository extends CrudRepository<Ledger, Long> {

    @Query
    public Ledger findLedgerByAccountID(long account_ID);

//    @Query
//    public Ledger findLedgerByID(long ID);

    @Query
    public Ledger findLedgerByTransactionNumber(long transactionNumber);
}
