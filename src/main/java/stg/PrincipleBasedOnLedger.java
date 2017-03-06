package stg;

import stg.account.Account;

import stg.transaction.Transaction;

import java.time.LocalDate;
import java.util.*;

import static java.time.LocalTime.now;
import static java.time.temporal.ChronoUnit.DAYS;


public class PrincipleBasedOnLedger {

    private int threshold = 5;

    static long getPrincipleAtTimeOfPayment(Account account) {
        return account.getBalance();
    }

    static long getAveragePrinciple(Account account, int period) {
        long averagePrinciple = 0;
        LocalDate endTime = LocalDate.now().plusDays(period);
        List<Transaction> periodForAverage = account.ledger.subLedger(LocalDate.now(), endTime);
        for (int i = 0; i < periodForAverage.size(); i++)
            averagePrinciple += account.ledger.balanceAfterTransaction(periodForAverage.get(i));
        return averagePrinciple / periodForAverage.size();
    }

    static long getBalanceAtSetDate(Account account, int daysPriorToInterest) {
        LocalDate time = account.ledger.getLast().getDate().minusDays(daysPriorToInterest);
        return account.ledger.balanceAfterPeriod((int) now().until(time, DAYS));

    }

    static long returnMaxPrinciples(Account account, int period) {
        long maxPrincipal = 0;
        LocalDate endTime = LocalDate.now().plusDays(period);
        List<Transaction> periodForMax = account.ledger.subLedger(LocalDate.now(), endTime);
        for (int i = 0; i < periodForMax.size(); i++) {
            if (maxPrincipal < account.ledger.balanceAfterTransaction(periodForMax.get(i))) {
                maxPrincipal = account.ledger.balanceAfterTransaction(periodForMax.get(i));
            }
        }
        return maxPrincipal;
    }

    static long returnMinPrinciples(Account account, int period) {
        LocalDate endTime = LocalDate.now().plusDays(period);
        List<Transaction> periodForMin = account.ledger.subLedger(LocalDate.now(), endTime);
        long minPrincipal = account.ledger.balanceAfterTransaction(periodForMin.get(0));
        for (int i = 1; i < periodForMin.size(); i++) {
            if (minPrincipal > account.ledger.balanceAfterTransaction(periodForMin.get(i))) {
                minPrincipal = account.ledger.balanceAfterTransaction(periodForMin.get(i));
            }
        }
        return minPrincipal;
    }

//    public long returnMinBalanceOverNumberOfDay(Account account, int period) {
//
//    }
//
//    public long returnMaxBalanceOverNumberOfDay(Account account, int period) {
//
//    }

    static public long principleDeterminedByEnum(Account acc) {

        long principal = 0;
        switch (acc.getPrincipleRule()) {

            case TIME_OF_CREDIT:
                principal = getPrincipleAtTimeOfPayment(acc);
                break;

            case EX_INTEREST_DATE:
                principal = getBalanceAtSetDate(acc, acc.getPeriod());
                break;

            case AVERAGE:
                principal = getAveragePrinciple(acc, acc.getPeriod());

            case MAX:
                principal = returnMaxPrinciples(acc, acc.getPeriod());
                break;

            case MIN:
                principal = returnMinPrinciples(acc, acc.getPeriod());
                break;

            case THRESHOLD_MAX:
                principal = returnMaxPrinciples(acc, acc.getPeriod());
                break;

            case THRESHOLD_MIN:
                principal = returnMinPrinciples(acc, acc.getPeriod());
                break;
        }
        return principal;
    }
}