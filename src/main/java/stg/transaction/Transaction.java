package stg.transaction;

import java.time.chrono.ChronoLocalDate;

/**
 * Created by rickjackson on 3/3/17.
 */
public class Transaction {
    private ChronoLocalDate timestamp;
    
    public Transaction(ChronoLocalDate timestamp) {
        this.timestamp = timestamp;
    }
    
    public ChronoLocalDate getDate() {
        return timestamp;
    }
}
