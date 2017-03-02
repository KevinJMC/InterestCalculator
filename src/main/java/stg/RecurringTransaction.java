package stg;

/**
 * Created by kevinmccann on 3/1/17.
 */
public class RecurringTransaction {
    int frequency;
    long amount;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    RecurringTransaction(int frequency, int amount) {
        this.frequency = frequency;
        this.amount = amount;
    }
}
