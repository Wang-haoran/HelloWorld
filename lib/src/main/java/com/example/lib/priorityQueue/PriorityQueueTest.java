package com.example.lib.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,11,19));
        pq.add(LocalDate.of(1910,1,6));
        pq.add(LocalDate.of(1506,2,9));

        System.out.println("Iterator over elements...");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        while (pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
