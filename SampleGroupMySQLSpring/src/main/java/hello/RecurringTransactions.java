package hello;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Recurring_Transactions")
public class RecurringTransactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;

	// adds accountID column with a foreign key. And creates a join to
	// lazily fetch the owner (LAZY means load only when data is requested so there aren't any load-time issues)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Account_ID")
	//This is the "account" specified in Accounts to manage the foreign key connection between two classes
	private Accounts account;

	@Column(name="frequency", nullable = false)
	private long frequency;

	@Column(name="amount", nullable = false)
	private double amount;

	@Column(name="description", nullable = false)
	private String description;

	public RecurringTransactions() {}

	public RecurringTransactions(long frequency, double	amount, String description) {
		this.frequency = frequency;
		this.amount = amount;
		this.description = description;
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

	public long getFrequency() {
		return frequency;
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = this.description;
	}
}

