package com.example.lib.threads;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private ReentrantLock bankLock = new ReentrantLock();
    private final double[] accounts;
    public Bank(int n,double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from,int to,double amount) {
        bankLock.lock();
        //if (accounts[from] < amount) return;
        try {
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d; ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total banlance : %10.2f%n", getTotalBanlance());
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBanlance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
