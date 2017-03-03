package stg;

import stg.account.Account;

import java.util.*;


public class PrincipleBasedOnLedger {

    Account account = new Account();

    long getPrincipleAtTimeOfPayment(int Payment){
        return account.getBalance();
    }

     Integer getAveragePrinciple(ArrayList<Integer> ledger, int period){

        Integer principle = 0;

        int startingIndex = ledger.size() - period;
        for(int i = startingIndex; i < ledger.size(); i++){
            principle += ledger.get(i);

        }
        return  principle/period;
    }

   public long getBalanceAtSetDate(int daysPriorToInterest){

         ///this method will call a getter from Rick's class to return a particular balance for the day
       return 0;
   }

    public Long returnMaxPrinciples(ArrayList<Long> ledger, int period){
        List<Long> newList = ledger.subList(ledger.size()-period, ledger.size());
        Collections.sort(newList);
        return newList.get(newList.size()-1);

    }

    public Long returnMinPrinciples(ArrayList<Long> ledger, int period){
        List<Long> newList = ledger.subList(ledger.size()-period, ledger.size());
        Collections.sort(newList);
        return newList.get(0);

    }

    public long returnMinBalanceOverNumberOfDay(ArrayList<Long> ledger, int days){

        ArrayList<Long> consecutiveDaysBalance = new ArrayList<>();
        for(int i = 0; i <= ledger.size()-days ; i++){
            if(ledger.get(i).equals(ledger.get(i+days -1))){

                consecutiveDaysBalance.add(ledger.get(i));
            }

        }

        Collections.sort(consecutiveDaysBalance);
        return consecutiveDaysBalance.get(0);
    }

    public long returnMaxBalanceOverNumberOfDay(ArrayList<Long> ledger, int days){

        ArrayList<Long> consecutiveDaysBalance = new ArrayList<>();
        for(int i = 0; i <= ledger.size()-days ; i++){
            if(ledger.get(i).equals(ledger.get(i+days -1))){

                consecutiveDaysBalance.add(ledger.get(i));
            }

        }

        Collections.sort(consecutiveDaysBalance);
        return consecutiveDaysBalance.get(consecutiveDaysBalance.size()-1);
    }
}