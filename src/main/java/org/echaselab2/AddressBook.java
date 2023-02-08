package org.echaselab2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo newBuddy){
        this.buddies.add(newBuddy);
    }

    public void removeBuddy(BuddyInfo remBuddy) {
        this.buddies.remove(remBuddy);
    }

    @Override
    public String toString(){
        StringBuilder bob = new StringBuilder("BOOK\n");
        for (BuddyInfo buddy : buddies)
        {
            bob.append("Buddy name: ").append(buddy.getName()).append(", Buddy phone number: ").append(buddy.getPhoneNumber()).append("\n");
        }
        return bob.toString();
    }
}