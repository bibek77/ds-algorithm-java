package com.github.bibek77.dsa.onsiteCoding;

import java.util.Map;

/**
 * @author bibek
 * Consider a bank with some intial amount of money. Consider an array which represents list of transactions which are going to come through customers. + means deposit - means withdrawl. Bank can choose from which customer they want to start serving the customers, and they can refuse any number of customers. But once they start they have to serve till the time its impossible to serve the customers. Maximize the total customers bank can serve.
 * <p>
 * Example :
 * Bank has 1 unit of money intially.
 * Customer transactions : [1, -3, 5, -2, 1]
 * <p>
 * answer = 3
 * <p>
 * Bank starts with customer with deposit of 5
 * 1+ 5 = 6
 * 6 - 2 = 4
 * 4 + 1 =5
 * <p>
 * If bank starts at in index 0 can only serve 1 customer
 * 1+1 =2
 * 2-3 = -1 not possible
 */
public class ServeMaxCustomer {

    public static void main(String[] args) {

        int initial = 1; // initial money with the bank
        int[] transactions = {1, -3, 5, -2, 1};
        ServeMaxCustomer serveMaxCustomer = new ServeMaxCustomer();
        System.out.println("Customer bank should start with is : " + serveMaxCustomer.serveMaxCustomer(initial, transactions));
    }

    public int serveMaxCustomer(int initial, int[] transactions) {
        int n = transactions.length;
        int maxCustomers = 0;
        int sum = initial;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum += transactions[i];
            while (sum < 0) {
                sum -= transactions[start++];
            }
            maxCustomers = Math.max(maxCustomers, i - start + 1);
        }
        return maxCustomers;
    }
}
