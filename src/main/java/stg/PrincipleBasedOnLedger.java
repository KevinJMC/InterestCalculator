package stg;

import stg.account.Account;
import stg.ledger.Ledger;
import stg.transaction.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.LocalTime.now;
import static java.time.temporal.ChronoUnit.DAYS;


public class PrincipleBasedOnLedger {

    long getPrincipleAtTimeOfPayment(Account account){
        return account.getBalance();
    }

     long getAveragePrinciple(Account account, int period){
        long averagePrinciple = 0;
        LocalDate endTime = LocalDate.now().plusDays(period);
        List<Transaction> periodForAverage = account.ledger.subLedger(LocalDate.now(), endTime);
        for(int i = 0; i<periodForAverage.size(); i++)
            averagePrinciple += account.ledger.balanceAfterTransaction(periodForAverage.get(i));
        return  averagePrinciple/periodForAverage.size();
    }
    
    public long getBalanceAtSetDate(Account account, int daysPriorToInterest){
        LocalDate time = account.ledger.getLast().getDate().minusDays(daysPriorToInterest);
        return account.ledger.balanceAfterPeriod((int) now().until(time, DAYS));

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

    public long principleDeterminedByenum(Account acc){

        switch(acc.getPrincipleRule()){

            case TIME_OF_CREDIT:
                getPrincipleAtTimeOfPayment(acc);
                break;

            case EX_INTEREST_DATE:
                break;

            case AVERAGE:
                break;

            case MAX:
                break;

            case MIN:
                break;

            case THRESHOLD_MAX:
                returnMaxBalanceOverNumberOfDay(acc);
                break;

            case THRESHOLD_MIN:
                break;
        }
    }
}