package stg.model.account;

import lombok.Getter;
import lombok.Setter;
import stg.PrincipalRules;
import stg.model.account.ledger.Ledger;
import stg.model.transaction.RecurringTransaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by kevinmccann on 3/1/17.
 */
@Entity(name = "account")
public class Account {
    @Id
    // @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    // @Setter
    // @Getter
    @Column(name = "number")
    private String number;
    
    // @Setter
    // @Getter
    @Column(name = "accountType")
    // @Column(name = "accountType", nullable = false, length = 40)
    private String accountType;
    
    // @Setter
    // @Getter
    @Column(name = "balance")
    private long balance;
    
    // @Setter
    // @Getter
    @Column(name = "interestRate")
    private double interestRate;
    
    // @Getter
    @Transient
    private final double overdraftPenalty = 35.00;
    
    // @Setter
    // @Getter
    @Column(name = "requiredMinimumBalance")
    private long requiredMinimumBalance;
    
    // @Setter
    // @Getter
    @Column(name = "isMinimumBalanceRequired")
    private boolean isMinimumBalanceRequired;
    
    // @Setter
    // @Getter
    @Transient
    public final Ledger ledger = new Ledger();
    
    // @Setter
    // @Getter
    @Transient
    public final Ledger recurringTransactions = new Ledger();
    
    // @Setter
    // @Getter
    @Transient
    private PrincipalRules principleRule;
    
    // @Setter
    // @Getter
    @Transient
    private int interval;
    
    public Account() {}
    
    public Account(String number, String accountType, long balance,
                   double interestRate, long requiredMinimumBalance,
                   boolean isMinimumBalanceRequired) {
        this.number = number;
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.requiredMinimumBalance = requiredMinimumBalance;
        this.isMinimumBalanceRequired = isMinimumBalanceRequired;
    }
    
    public long getId() {
        return id;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
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
    
    public void setIsMinimumBalanceRequired(boolean isMinimumBalanceRequired) {
        this.isMinimumBalanceRequired = isMinimumBalanceRequired;
    }
    
    public PrincipalRules getPrincipleRule() {
        return principleRule;
    }
    
    public void setPrincipalRule(PrincipalRules principleRule) {
        this.principleRule = principleRule;
    }
    
    public int getInterval() {
        return interval;
    }
    
    public void setInterval(int interval) {
        this.interval = interval;
    }
    
    public boolean isOverdrawn() {
        return balance < 0L;
    }
    
    
    // public final Ledger ledger;
    // private String accountType;
    // private long balance;
    // private double interestRate;
    // private final double overdraftPenalty = 35.00;
    // private long requiredMinimumBalance;
    // private boolean isMinimumBalanceRequired;
    // private List<RecurringTransaction> recurringTransactions;
    // private PrincipalRules principleRule;
    // private int interval;
    //
    // private double period;
    //
    // public Account(Ledger ledger) {
    //     this.ledger = ledger;
    // }
    //
    // public PrincipalRules getPrincipleRule() {
    //     return principleRule;
    // }
    //
    // public void setPrincipleRule(PrincipalRules principleRule) {
    //     this.principleRule = principleRule;
    // }
    //
    // public String getAccountType() {
    //     return accountType;
    // }
    //
    // public void setAccountType(String accountType) {
    //     this.accountType = accountType;
    // }
    //
    // public long getBalance() {
    //     return balance;
    // }
    //
    // public void setBalance(long balance) {
    //     this.balance = balance;
    // }
    //
    // public double getInterestRate() {
    //     return interestRate;
    // }
    //
    // public void setInterestRate(double interestRate) {
    //     this.interestRate = interestRate;
    // }
    //
    // public double getOverdraftPenalty() {
    //     return overdraftPenalty;
    // }
    //
    // public long getRequiredMinimumBalance() {
    //     return requiredMinimumBalance;
    // }
    //
    // public void setRequiredMinimumBalance(long requiredMinimumBalance) {
    //     this.requiredMinimumBalance = requiredMinimumBalance;
    // }
    //
    // public boolean isMinimumBalanceRequired() {
    //     return isMinimumBalanceRequired;
    // }
    //
    // public void setMinimumBalanceRequired(boolean minimumBalanceRequired) {
    //     isMinimumBalanceRequired = minimumBalanceRequired;
    // }
    //
    // public List<RecurringTransaction> getRecurringTransactions() {
    //     return recurringTransactions;
    // }
    //
    // public void setRecurringTransactions(List<RecurringTransaction> recurringTransactions) {
    //     this.recurringTransactions = recurringTransactions;
    // }
    //
    // public boolean isOverdrawn() {
    //     return balance<=0;
    // }
    //
    // public int getInterval() {
    //     return interval;
    // }
    //
    // public void setInterval(int interval) {
    //     this.interval = interval;
    // }
    //
    // public double getPeriod() {
    //     return period;
    // }
    //
    // public void setPeriod(double period) {
    //     this.period = period;
    // }
}
