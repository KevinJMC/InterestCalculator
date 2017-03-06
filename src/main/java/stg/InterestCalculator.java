package stg;

import stg.account.Account;

public class InterestCalculator {

    //FINISH
    public InterestCalculator getInterest(InterestCalculator calc){
        return calc;
    }

    public long calculateSimpleInterest(Account account, int interval){
        //need principle rules
        //need required minimum balance
        //
        long result = 0;
        if(!account.isOverdrawn()){
            result = (long) (account.getBalance() * (1 + account.getInterestRate() * interval));
        }
            return result;
    }

    public long calculateComplexInterest(Account account, int interval, double period) {

//         (long) (account.getBalance()* Math.pow((1 + account.getInterestRate() / period), (period * interval))) - account.getBalance();
        long interest = 0;
        for(int i = 0; i < interval; i += period) {
            interest += account.getPrincipleAtTime(i) * account.getInterestRate();
        }

    }
    
    // public long calculateSimpleInterest(Account account, Object interval) {
    //     Double interest = account.getBalance() * (account.getInterest()
    //                                                      .getAnnualRate()
    //                                               * account.getInterest()
    //                                                        .getInterval());
    //     return interest.longValue();
    // }
    //
    // public long calculateComplexInterest(Account account, Object interval,
    //                                      int frequency) {
    //     // balance * Math.pow(1 + (rate / interval), interval * years);
    //     Double interest = account.getBalance()
    //                       * Math.pow((account.getInterest().getAnnualRate()
    //                                   / account.getInterest()
    //                                            .getInterval()),
    //                                  account.getInterest().getInterval()
    //                                  * account.getInterest().getYears());
    //     return interest.longValue();
    // }
}
