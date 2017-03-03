package stg.transaction;

import java.time.chrono.ChronoLocalDate;

/**
 * Created by rickjackson on 3/3/17.
 */
public class Transaction {
    private ChronoLocalDate timestamp;
    private long amount;
    
    public Transaction(ChronoLocalDate timestamp, long amount) {
        this.timestamp = timestamp;
        this.amount = amount;
    }
    
    public ChronoLocalDate getDate() {
        return timestamp;
    }
    
    public void setDate(ChronoLocalDate timestamp) {
        this.timestamp = timestamp;
    }
    
    public long getAmount() {
        return amount;
    }
    
    public void setAmount(long amount) {
        this.amount = amount;
    }
}
