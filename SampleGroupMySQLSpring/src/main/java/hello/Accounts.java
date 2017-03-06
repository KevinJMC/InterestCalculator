package hello;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;

	// The 'mappedBy = "account"' attribute specifies that
	// the 'private Accounts account;' field in Ledger owns the
	// relationship (i.e. contains the foreign key for the query to
	// find all transactions for an .
	@OneToMany(mappedBy = "account")
	private List<Ledger> transactions;

	@OneToMany(mappedBy = "account")
	private List<RecurringTransactions> recurringTransactions;

	@Column(name="Account_Number", nullable = false)
	private long accountNumber;

	@Column(name="Account_Type", nullable = false)
    private String accountType;

	@Column(name="Balance", nullable = false)
    private double balance;

	@Column(name="Interest_Rate", nullable = false)
	private double interestRate;

	@Column(name="Overdraft_Penalty", nullable = false)
	private double overdraftPenalty;

	@Column(name="Required_Minimum_Balance", nullable = false)
	private double requiredMinimumBalance;

	@Column(name="Is_Minimum_Balance_Required", nullable = false)
	private boolean isMinimumBalanceRequired;

	@Column(name="Is_Overdrawn", nullable = false)
	private boolean isOverdrawn;

	public Accounts() {}

	public Accounts(long accountNumber, String accountType, double balance,
					double interestRate, double overdraftPenalty, double requiredMinimumBalance,
					boolean isMinimumBalanceRequired, boolean isOverdrawn) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraftPenalty = overdraftPenalty;
		this.requiredMinimumBalance = requiredMinimumBalance;
		this.isMinimumBalanceRequired = isMinimumBalanceRequired;
		this.isOverdrawn = isOverdrawn;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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

	public void setBalance(double balance) {
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

	public void setOverdraftPenalty(double overdraftPenalty) {
		this.overdraftPenalty = overdraftPenalty;
	}

	public double getRequiredMinimumBalance() {
		return requiredMinimumBalance;
	}

	public void setRequiredMinimumBalance(double requiredMinimumBalance) {
		this.requiredMinimumBalance = requiredMinimumBalance;
	}

	public boolean getIsMinimumBalanceRequired() {
		return isMinimumBalanceRequired;
	}

	public void setIsMinimumBalanceRequired(boolean isMinimumBalanceRequired) {
		this.isMinimumBalanceRequired = isMinimumBalanceRequired;
	}

	public boolean getIsOverdrawn() {
		return isOverdrawn;
	}

	public void setIsOverdrawn(boolean isOverdrawn) {
		this.isOverdrawn = isOverdrawn;
	}


}

