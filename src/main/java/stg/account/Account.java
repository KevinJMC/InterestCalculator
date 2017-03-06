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
    private PrincipleRules principleRule;

    protected boolean isOverdrawn() {
        if (getBalance() >= getRequiredMinimumBalance()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Account() {};


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
}