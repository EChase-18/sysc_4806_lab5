/*
Ethan Chase (101108986)
SYSC4806 - Lab 1
January 11, 2023
 */

package org.echaselab2;

/**
 * Creates an address book and adds two new buddyinfos to the address book, then prints out the contents in the address book.
 */
public class Main {
    public static void main(String[] args) {
        AddressBook newBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Ethan", "613-613-6130");
        BuddyInfo buddy2 = new BuddyInfo("Chase", "613-613-6136");

        newBook.addBuddy(buddy1);
        newBook.addBuddy(buddy2);

//        newBook.printBook();
    }
}