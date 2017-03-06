package stg;

import java.lang.reflect.Array;
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

        List<Long> newList;
        long min = ledger.get(0);
        long  temp = 0;
        int counter = 0;
        for(int i = 0; i < ledger.size() - days; i++){
            counter = 1;
            newList =  ledger.subList(i, i+days);
            for(int z = 0; z < newList.size()-1; z++ ){
                if(newList.get(0)<=newList.get(z+1)){
                    counter++;
                    if(counter == days){
                        temp = ledger.get(i);
                        if(temp<min){
                            min = temp;
                        }
                    }
                }
            }
        }
        return  min;
    }

    public long returnMaxBalanceOverNumberOfDay(ArrayList<Long> ledger, int days){

      List<Long> newList;
        long high = 0;
        long  min = 0;
        int counter = 0;
      for(int i = 0; i < ledger.size() - days; i++){
          counter = 1;
          newList =  ledger.subList(i, i+days);
            for(int z = 0; z < newList.size()-1; z++ ){
                if(newList.get(0)<=newList.get(z+1)){
                    counter++;
                    if(counter == days){
                        min = ledger.get(i);
                        if(min>high){
                            high = min;
                        }
                    }
                }
            }
      }
      return  high;
    }
}