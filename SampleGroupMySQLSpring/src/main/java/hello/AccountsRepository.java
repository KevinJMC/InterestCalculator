package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    @Query
    public Accounts findAccountsByAccountNumber(long accountNumber);

//    @Query
//    public Accounts findAccountsByID(long ID);
}
