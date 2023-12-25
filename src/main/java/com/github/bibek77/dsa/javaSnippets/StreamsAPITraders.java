package com.github.bibek77.dsa.javaSnippets;

import com.github.bibek77.dsa.javaSnippets.refClass.Trader;
import com.github.bibek77.dsa.javaSnippets.refClass.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bibek
 */
public class StreamsAPITraders {
    public static void main(String[] args) {
        List<Transaction> transactionList = getTransactionList();

        // Find all transactions in the year 2011 and sort them by value
        List<Transaction> transactionListSorted = transactionList
                .stream().filter(item -> item.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).toList();

        // What are all the unique cities where the traders work
        List<String> uniqueCities = transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().toList();

        Set<String> uniqueCitiesSet = transactionList.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                                .collect(Collectors.toSet());

        // Find all the traders from cambridge and sort them by name
        List<Trader> traderList = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).toList();
        // .map(transaction -> transaction.getTrader()) -> .map(Transaction::getTrader)
        // .sorted(Comparator.comparing(Trader::getName)).toList();
        // -> .sorted((trader1, trader2) -> trader1.getName().compareTo(trader2.getName())).toList()

        // Return a string of all the traders name sorted alphabetically
        String allTraderName = transactionList.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .reduce("", (s1, s2) -> s1.concat(s2));

        String allTraderNameBetterWay = transactionList.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        // collect(joining()); // uses StringBuilder internally, more efficient , returns combined string
        System.out.println(allTraderName);
        System.out.println(allTraderNameBetterWay);

        // Are any traders based out of Milan
        boolean tradersFromMilan = transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(name-> name.equals("Milan"));
        //Also -> .anyMatch(transaction -> transaction.getTrader().getName().equals("Milan"));
        System.out.println(tradersFromMilan);

        // Print all the transaction values form traders living in Cambridge
        transactionList.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Whats the highest value of all the transactions ?
        int highestValue = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(highestValue);

        // Transaction with the smallest value
        Optional<Integer> smallestValue = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(smallestValue.orElse(0));

        // ALternate Way
        Optional<Transaction> min = transactionList.stream()
                .min(Comparator.comparing(Transaction::getValue));


    }

    private static List<Transaction> getTransactionList() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactionList;
    }

}
