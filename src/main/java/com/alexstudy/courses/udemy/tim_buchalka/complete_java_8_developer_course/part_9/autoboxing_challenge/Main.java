package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_9.autoboxing_challenge;

/**
 * Created by Alex on 10/12/2016.
 */

/**
 * You job is to create a simple banking application.
 * There should be a Bank class
 * It should have an arraylist of Branches
 * Each Branch should have an arraylist of Customers
 * The Customer class should have an arraylist of Doubles (transactions)
 * Customer:
 * Name, and the ArrayList of doubles.
 * Branch:
 * Need to be able to add a new customer and initial transaction amount.
 * Also needs to add additional transactions for that customer/branch
 * Bank:
 * Add a new branch
 * Add a customer to that branch with initial transaction
 * Add a transaction for an existing customer for that branch
 * Show a list of customers for a particular branch and optionally a list
 * of their transactions
 * Demonstration autoboxing and unboxing in your code
 * Hint: Transactions
 * Add data validation.
 * e.g. check if exists, or does not exist, etc.
 * Think about where you are adding the code to perform certain actions
 */

public class Main {
    public static void main(String[] args) {
        Bank ukrSib = new Bank();
        ukrSib.addBranch(new Branch("Odessa", new Customer("Alex", 10d, 5d, 10d),
                new Customer("Marina", 5d, 10d, 15d)));
        ukrSib.addTransaction("Odessa", "Alex", 100d);
        ukrSib.printCustomers("Odessa", false);
        ukrSib.printCustomers("Odessa", true);
    }
}
