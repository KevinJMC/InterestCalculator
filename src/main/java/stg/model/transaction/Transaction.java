package stg.model.transaction;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rickjackson on 3/3/17.
 */
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "timestamp", nullable = false)
    private final LocalDateTime timestamp;
    
    @Column(name = "type", nullable = false)
    private final String type;
    
    @Column(name = "amount")
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
