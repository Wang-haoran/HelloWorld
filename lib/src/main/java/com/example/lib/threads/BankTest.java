package com.example.lib.threads;

import sun.rmi.runtime.Log;

public class BankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BANLANCE = 1000;
    public static final int MAX_AMOUNT = 1000;
    public static final int DELAY =10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS,INITIAL_BANLANCE);
        for (int i = 0;i < MAX_AMOUNT;i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        System.out.println("toAccount = " + toAccount);
                        double amount = MAX_AMOUNT * Math.random();
                        System.out.println("amount = " + amount);
                        //Log.getLog("w",String.valueOf(amount));
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
            }
        };
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
