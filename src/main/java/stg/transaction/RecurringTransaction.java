package stg.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import stg.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by kevinmccann on 3/1/17.
 */
@Entity
@Table(name="Reoccurring_Transactions")
public class RecurringTransaction  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_ID")
    private Account account;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("frequency")
    private int frequency;


    // FIXME, what's wrong with it exactly?
    public static int DAY_OF_MONTH;


    @JsonProperty("accountNumber")
    private double accountNumber;

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }





    public RecurringTransaction(double amount, int frequency) {
        this.amount = amount;
        this.frequency = frequency;
    }

    public RecurringTransaction() {}
    
    public void setDayOfMonth(int day) {
        if (day < 1 || day > 28) {
            throw new IllegalArgumentException("day: " + day);
        }
        this.DAY_OF_MONTH = day;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    // int frequency;
    // long amount;
    //
    // public int getFrequency() {
    //     return frequency;
    // }
    //
    // public void setFrequency(int frequency) {
    //     this.frequency = frequency;
    // }
    //
    // public long getAmount() {
    //     return amount;
    // }
    //
    // public void setAmount(long amount) {
    //     this.amount = amount;
    // }
    //
    // public RecurringTransaction(int frequency, long amount) {
    //     this.frequency = frequency;
    //     this.amount = amount;
    // }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public double getAmount() {
        return amount;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }
}
