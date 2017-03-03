package stg.account;

import stg.transaction.RecurringTransaction;

import java.util.List;

/**
 * Created by kevinmccann on 3/1/17.
 */
public class Account {
    private String accountType;
    private long balance;
    private double interestRate;
    private long overdraftPenalty;
    private long requiredMinimumBalance;
    private boolean isMinimumBalanceRequired;
    private List<RecurringTransaction> recurringTransactions;
    private boolean overdrawn;

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

    public long getOverdraftPenalty() {
        return overdraftPenalty;
    }

    public void setOverdraftPenalty(long overdraftPenalty) {
        this.overdraftPenalty = overdraftPenalty;
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

    public boolean getOverdrawn() {
        return overdrawn;
    }

    public void setOverdrawn() {
        if(getBalance()<=0)
            overdrawn = true;
    }
}
