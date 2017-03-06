package stg.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import stg.account.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rickjackson on 3/3/17.
 */
@Entity
@Table(name="Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;

    @JsonProperty("accountNumber")
    private double accountNumber;

    @JsonProperty("timestamp")
    private final LocalDateTime timestamp;

    @JsonProperty("type")
    private final String type;

    @JsonProperty("amount")
    private final long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_ID")
    private Account account;



    public Transaction(LocalDateTime timestamp, String type, long amount) {
            this.timestamp = timestamp;
            this.type = type;
        this.amount = amount;
    }

    public Transaction() {
        this.timestamp = null;
        this.type = null;
        this.amount = 0;
    };
    
    public LocalDate getDate() {
        return timestamp.toLocalDate();
    }
    
    public String getType() {
        return type;
    }
    
    public long getAmount() {
        return amount;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
