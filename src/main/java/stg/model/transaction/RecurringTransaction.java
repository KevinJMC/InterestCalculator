package stg.model.transaction;

import java.time.LocalDateTime;

/**
 * Created by kevinmccann on 3/1/17.
 */
public class RecurringTransaction{

    public static int DAY_OF_MONTH;
    
    public void setDayOfMonth(int day) {
        if (day < 1 || day > 28) {
            throw new IllegalArgumentException("day: " + day);
        }
        this.DAY_OF_MONTH = day;
    }
    
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

     public RecurringTransaction(int frequency, long amount) {
         this.frequency = frequency;
         this.amount = amount;
     }
}
