package org.echaselab2;

import javax.persistence.*;
import java.util.List;

public class BuddyInfoJpaTest {
    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo();
//        buddy1.setId(1);
        buddy1.setName("Edward");
        buddy1.setPhoneNumber("123-456");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclab2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction newTrans = em.getTransaction();

        newTrans.begin();

        em.persist(buddy1);

        newTrans.commit();

        Query newQuery = em.createQuery("SELECT b FROM BuddyInfo b");

        List<BuddyInfo> tableOfBuddies = newQuery.getResultList();

        System.out.println("--- Buddies ---");
        for (BuddyInfo buddy : tableOfBuddies) {
            System.out.println("Name: "+buddy.getName()+", Phone: "+buddy.getPhoneNumber());
        }

        em.close();
        emf.close();
    }
}