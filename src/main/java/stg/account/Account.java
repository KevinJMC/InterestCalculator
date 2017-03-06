package stg.account;

import stg.PrincipleRules;
import stg.ledger.Ledger;
import stg.transaction.RecurringTransaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.persistence.Transient;
import java.beans.*;
import java.util.List;

@Entity
@Table(name="Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


   // @JsonProperty("Ledger")
    @Transient
    public Ledger ledger;
    // Need to Include Ledger!

    @OneToMany(mappedBy = "account")
    private List<RecurringTransaction> recurringTransactions;

    @JsonProperty("Account_Number")
    private double accountNumber;

    @JsonProperty("Account_Type")
    private String accountType;

    @JsonProperty("Balance")
    private double balance;

    @JsonProperty("Interest_Rate")
    private double interestRate;

    @Transient
    private final double overdraftPenalty = 35.00;

    @JsonProperty("Required_Minimum_Balance")
    private double requiredMinimumBalance;

    @JsonProperty("Is_Minimum_Balance_Required")
    private boolean isMinimumBalanceRequired;

    @JsonProperty("Is_Overdrawn")
    private boolean isOverdrawn;

    @Transient
    private int interval;

    @Transient
    private int period;

    @Transient
    private PrincipleRules principleRule;

    public boolean isOverdrawn() {
        if (getBalance() >= getRequiredMinimumBalance()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Account() {};

    public Ledger getLedger() {
        return ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }


    // Front-End EndPoint

    public Account(long accountNumber, String accountType, double balance,
                    double interestRate, double requiredMinimumBalance,
                    boolean isMinimumBalanceRequired) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.requiredMinimumBalance = requiredMinimumBalance;
        this.isMinimumBalanceRequired = isMinimumBalanceRequired;
        this.isOverdrawn = isOverdrawn();
    }

    public Account(long accountNumber, double interestRate, double balance, double requiredMinimumBalance) {
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.balance = balance;
        this.requiredMinimumBalance = requiredMinimumBalance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
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

    public double getRequiredMinimumBalance() {
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

    // Initial: if it has initial balance
    public void initialMinimumBalance() {
        if (balance >= requiredMinimumBalance) {
            setMinimumBalanceRequired(true);
        } else {
            setMinimumBalanceRequired(false);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
