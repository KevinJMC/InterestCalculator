package stg;


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
        if(!account.getOverdrawn()){
            result = (long) (account.getBalance() * (1 + account.getInterestRate() * interval));
        }
            return result;
    }

    public long calculateComplexInterest(Account account, int interval, int frequency){


        return (long) (account.getBalance()* Math.pow((1 + account.getInterestRate()
                / frequency), (frequency * interval))) - account.getBalance();

    }
}
