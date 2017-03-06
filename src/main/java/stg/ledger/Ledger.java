package stg.ledger;

import stg.transaction.Transaction;
import stg.account.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/**
 * Created by rickjackson on 3/3/17.
 */
@Entity
@Table(name="Ledger")
public class Ledger {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="Account_Id")
    private Account account;

    @OneToMany(mappedBy = "account")
    LinkedList<Transaction> transactions;
    
    public Ledger() {
        this.transactions = new LinkedList<>();
    }
    
    public Ledger(Collection<? extends Transaction> c) {
        this();
        this.transactions = new LinkedList<>(c);
    }
    
    public Transaction getFirst() {
        return transactions.getFirst();
    }
    
    public Transaction getLast() {
        return transactions.getLast();
    }
    
    public Transaction removeFirst() {
        return transactions.removeFirst();
    }
    
    public Transaction removeLast() {
        return transactions.removeLast();
    }
    
    public void addFirst(Transaction t) {
        transactions.addFirst(t);
    }
    
    public void addLast(Transaction t) {
        transactions.addLast(t);
    }
    
    public boolean contains(Transaction t) {
        return transactions.contains(t);
    }
    
    public int size() {
        return transactions.size();
    }
    
    public boolean add(Transaction t) {
        return transactions.add(t);
    }
    
    public boolean remove(Transaction t) {
        return transactions.remove(t);
    }
    
    public boolean addAll(Collection<? extends Transaction> c) {
        return transactions.addAll(c);
    }
    
    public boolean addAll(int index, Collection<? extends Transaction> c) {
        return transactions.addAll(index, c);
    }
    
    public void clear() {
        transactions.clear();
    }
    
    public Transaction get(int index) {
        return transactions.get(index);
    }
    
    public Transaction set(int index, Transaction t) {
        return transactions.set(index, t);
    }
    
    public void add(int index, Transaction t) {
        transactions.add(index, t);
    }
    
    public Transaction remove(int index) {
        return transactions.remove(index);
    }
    
    public int indexOf(Transaction t) {
        return transactions.indexOf(t);
    }
    
    public int lastIndexOf(Transaction t) {
        return transactions.lastIndexOf(t);
    }
    
    public Transaction peek() {
        return transactions.peek();
    }
    
    public Transaction transaction() {
        return transactions.element();
    }
    
    public Transaction poll() {
        return transactions.poll();
    }
    
    public Transaction remove() {
        return transactions.remove();
    }
    
    public boolean offer(Transaction t) {
        return transactions.offer(t);
    }
    
    public boolean offerFirst(Transaction t) {
        return transactions.offerFirst(t);
    }
    
    public boolean offerLast(Transaction t) {
        return transactions.offerLast(t);
    }
    
    public Transaction peekFirst() {
        return transactions.peekFirst();
    }
    
    public Transaction peekLast() {
        return transactions.peekLast();
    }
    
    public void push(Transaction t) {
        transactions.push(t);
    }
    
    public Transaction pop() {
        return transactions.pop();
    }
    
    public boolean removeFirstOccurrence(Transaction t) {
        return transactions.removeFirstOccurrence(t);
    }
    
    public boolean removeLastOccurrence(Transaction t) {
        return transactions.removeLastOccurrence(t);
    }
    
    public List<Transaction> subLedger(int fromIndex, int toIndex) {
        return transactions.subList(fromIndex, toIndex);
    }
    
    public List<Transaction> subLedger(LocalDate fromDate, LocalDate toDate) {
        if (fromDate.isBefore(toDate)) {
            throw new IllegalArgumentException("fromDate(" + fromDate + ") > "
                                               + "toDate(" + toDate + ")");
        }
        LinkedList<Transaction> l = new LinkedList<>();
        
        for (Transaction t : transactions) {
            if (!(t.getDate().isBefore(fromDate)
                  || t.getDate().isAfter(toDate))) {
                l.add(t);
            }
        }
        return l;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public ListIterator<Transaction> ledgerIterator(int index) {
        return transactions.listIterator();
    }
    
    public Iterator<Transaction> descendingIterator() {
        return transactions.descendingIterator();
    }
    
    public Object clone() {
        return transactions.clone();
    }
    
    public Object[] toArray() {
        return transactions.toArray();
    }
    
    public Transaction[] toArray(Transaction[] t) {
        return transactions.toArray(t);
    }
    
    public Spliterator<Transaction> spliterator() {
        return transactions.spliterator();
    }
    
    public void sort() {
        transactions.sort(byDate);
    }
    
    public void sort(Comparator<Transaction> c) {
        transactions.sort(c);
    }
    
    public static Comparator<Transaction> byDate =
            (t1, t2) -> (t1.getDate().compareTo(t2.getDate()));
    
}
