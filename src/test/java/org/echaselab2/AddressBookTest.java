package org.echaselab2;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    @org.junit.Test
    public void getBuddies() {
        AddressBook newBook = new AddressBook();
        BuddyInfo testBuddy = new BuddyInfo("Test", "123");

        newBook.addBuddy(testBuddy);

        List<BuddyInfo> returnedBuddies = newBook.getBuddies();

        assertEquals(returnedBuddies.size(), 1);
        assertEquals(returnedBuddies.get(0).getName(), "Test");
        assertEquals(returnedBuddies.get(0).getPhoneNumber(), "123");
    }

    @org.junit.Test
    public void addBuddy() {
        AddressBook newBook = new AddressBook();
        BuddyInfo testBuddy = new BuddyInfo("Test", "123");
        BuddyInfo testBuddy2 = new BuddyInfo("Tester", "456");

        newBook.addBuddy(testBuddy);
        newBook.addBuddy(testBuddy2);

        List<BuddyInfo> returnedBuddies = newBook.getBuddies();

        assertEquals(returnedBuddies.size(), 2);
        assertEquals(returnedBuddies.get(1).getName(), "Tester");
        assertEquals(returnedBuddies.get(1).getPhoneNumber(), "456");
        assertNotEquals(returnedBuddies.get(0).getName(), "Tester");
        assertNotEquals(returnedBuddies.get(0).getPhoneNumber(), "456");
    }
}