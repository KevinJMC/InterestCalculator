package stg;

import java.util.List;

/**
 * Created by kevinmccann on 3/1/17.
 */
public class Account {
    String accountType;
    long balance;
    double interestRate;
    long overdraftPenalty;
    long requiredMinimumBalance;
    boolean isMinimumBalanceRequired;
    List<RecurringTransaction> recurringTransactions;

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

}
