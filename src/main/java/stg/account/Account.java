package stg.account;

import stg.PrincipleRules;
import stg.ledger.Ledger;
import stg.transaction.RecurringTransaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("balance")
    private long balance;

    @JsonProperty("interestRate")
    private double interestRate;

    @Transient
    private final double overdraftPenalty = 35.00;

    @JsonProperty("requiredMinimumBalance")
    private long requiredMinimumBalance;

    @JsonProperty("isMinimumBalanceRequired")
    private boolean isMinimumBalanceRequired;

    @Transient
    private List<RecurringTransaction> recurringTransactions;

    @Transient
    private PrincipleRules principleRule;

    @Transient
    public final Ledger ledger;
    
    public Account(Ledger ledger) {
        this.ledger = ledger;
    }



    public PrincipleRules getPrincipleRule() {
        return principleRule;
    }

    public void setPrincipleRule(PrincipleRules principleRule) {
        this.principleRule = principleRule;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getOverdraftPenalty() {
        return overdraftPenalty;
    }

    public long getRequiredMinimumBalance() {
        return requiredMinimumBalance;
    }

    public void setRequiredMinimumBalance(long requiredMinimumBalance) {
        this.requiredMinimumBalance = requiredMinimumBalance;
    }

    public boolean isMinimumBalanceRequired() {
        return isMinimumBalanceRequired;
    }

    public void setMinimumBalanceRequired(boolean minimumBalanceRequired) {
        isMinimumBalanceRequired = minimumBalanceRequired;
    }

    public List<RecurringTransaction> getRecurringTransactions() {
        return recurringTransactions;
    }

    public void setRecurringTransactions(List<RecurringTransaction> recurringTransactions) {
        this.recurringTransactions = recurringTransactions;
    }

    public boolean isOverdrawn() {
        return balance>=0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
