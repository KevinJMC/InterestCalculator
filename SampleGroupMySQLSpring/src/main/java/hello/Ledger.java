package hello;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Ledger")
public class Ledger {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;

    // adds accountID column with a foreign key. And creates a join to
    // lazily fetch the owner (LAZY means load only when data is requested so there aren't any load-time issues)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_ID")
    //This is the "account" specified in Accounts to manage the foreign key connection between two classes
    private Accounts account;

    @Column(name="Transaction_Number", nullable = false)
    private long transactionNumber;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="Credit", nullable = false)
    private double credit;

    @Column(name="Debit", nullable = false)
    private double debit;

    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    public Ledger() {}

    public Ledger(long transactionNumber, String description, double credit, double debit, Timestamp timestamp) {
        this.transactionNumber = transactionNumber;
        this.description = description;
        this.credit = credit;
        this.debit = debit;
        this.timestamp = timestamp;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

