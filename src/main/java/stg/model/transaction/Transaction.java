package stg.model.transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rickjackson on 3/3/17.
 */
public class Transaction {
    private final LocalDateTime timestamp;
    private final String type;
    private final long amount;
    
    public Transaction(LocalDateTime timestamp, String type, long amount) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
    }
    
    public LocalDate getDate() {
        return timestamp.toLocalDate();
    }
    
    public String getType() {
        return type;
    }
    
    public long getAmount() {
        return amount;
    }
}
