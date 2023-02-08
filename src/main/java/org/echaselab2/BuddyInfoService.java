package org.echaselab2;

public interface BuddyInfoService {
    void addBuddy(String name, String phone);

    BuddyInfo removeBuddy(String name, String phone);
}
