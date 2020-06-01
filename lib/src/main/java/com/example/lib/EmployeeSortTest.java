package com.example.lib;

import java.lang.reflect.Array;
import java.util.Arrays;

import sun.rmi.runtime.Log;

public class EmployeeSortTest {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry",35000);
        staff[1] = new Employee("Carl",40000);
        staff[2] = new Employee("Tony",50000);

        Arrays.sort(staff);

        for (Employee staffs : staff) {
            System.out.println("name = " + staffs.getName() + ",salary = " + staffs.getSalary());
        }
    }
}
