package stg.account;

import stg.PrincipleRules;
import stg.ledger.Ledger;
import stg.transaction.RecurringTransaction;

import java.util.List;

/**
 * Created by kevinmccann on 3/1/17.
 */
public class Account {
    public final Ledger ledger;
    private String accountType;
    private long balance;
    private double interestRate;
    private final double overdraftPenalty = 35.00;
    private long requiredMinimumBalance;
    private boolean isMinimumBalanceRequired;
    private List<RecurringTransaction> recurringTransactions;
    private PrincipleRules principleRule;
    
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
}