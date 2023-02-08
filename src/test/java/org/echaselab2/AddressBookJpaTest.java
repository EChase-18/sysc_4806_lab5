package org.echaselab2;

import javax.persistence.*;
import java.util.List;

public class AddressBookJpaTest {
    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo();
//        buddy1.setId(1);
        buddy1.setName("Ethan");
        buddy1.setPhoneNumber("123-123");

        BuddyInfo buddy2 = new BuddyInfo();
//        buddy2.setId(2);
        buddy2.setName("Chase");
        buddy2.setPhoneNumber("456-456");

        AddressBook book1 = new AddressBook();
//        book1.setId(999);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclab2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction newTrans = em.getTransaction();

        newTrans.begin();

//        em.persist(buddy1);
//
//        em.persist(buddy2);

        book1.addBuddy(buddy1);
        book1.addBuddy(buddy2);

        em.persist(book1);

        newTrans.commit();

        Query newQuery = em.createQuery("SELECT b FROM AddressBook b");

        List<AddressBook> addressBookResult = newQuery.getResultList();

        System.out.println("--- AddressBook with Buddies ---");
        for (AddressBook book : addressBookResult) {
            System.out.println("Book id: "+book.getId());
            System.out.println("-----");

            List<BuddyInfo> buddiesInBook = book.getBuddies();

            for(BuddyInfo buddy : buddiesInBook) {
                System.out.println("Id: " + buddy.getId() +", Name: " + buddy.getName() + ", Phone: " + buddy.getPhoneNumber());
            }
        }

        em.close();
        emf.close();
    }
}
