package com.example.lib.sync;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFund;

    public Bank(int n,double initialBanlance) {
        accounts = new double[n];
        bankLock = new ReentrantLock();
        sufficientFund = bankLock.newCondition();
        Arrays.fill(accounts,initialBanlance);
    }

    public synchronized void transfer(int from,int to,double amount) throws InterruptedException{
        try {
            while (accounts[from] < amount)
                wait();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf("TotalBanlance = %10.2f%n",getBanlance());
            notifyAll();
        } finally {
            bankLock.unlock();
        }
    }

    private double getBanlance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
