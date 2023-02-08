package org.echaselab2;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo newBuddy = new BuddyInfo("Sample", "111");

        assertEquals(newBuddy.getName(), "Sample");
    }

    @Test
    public void getPhoneNumber() {
        BuddyInfo newBuddy = new BuddyInfo("Sample", "111");

        assertEquals(newBuddy.getPhoneNumber(), "111");
    }

    @Test
    public void setName() {
        BuddyInfo newBuddy = new BuddyInfo("Sample", "111");
        newBuddy.setName("Changed");

        assertEquals(newBuddy.getName(), "Changed");
    }

    @Test
    public void setPhoneNumber() {
        BuddyInfo newBuddy = new BuddyInfo("Sample", "111");
        newBuddy.setPhoneNumber("222");

        assertEquals(newBuddy.getPhoneNumber(), "222");
    }
}