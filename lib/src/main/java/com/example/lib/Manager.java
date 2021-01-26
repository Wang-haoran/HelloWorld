package com.example.lib;

public class Manager extends Employee{
    //private String name;
    private double bonus;

    public Manager(String name, double salary,int year,int month,int day) {
        super(name, salary,year,month,day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    public double getBonus() {
        return bonus;
    }
}
