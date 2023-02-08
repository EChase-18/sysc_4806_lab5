//package org.echaselab2;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Optional;
//
//@SpringBootApplication
//public class AccessingDataJpaApplication {
//    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(AccessingDataJpaApplication.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner demo(AddressBookRepository repository){
//        return (args) -> {
//            BuddyInfo buddy1 = new BuddyInfo("Jeff", "613-613-6133");
//            BuddyInfo buddy2 = new BuddyInfo("Ethan", "613-613-9999");
//            BuddyInfo buddy3 = new BuddyInfo("Chase", "613-613-1111");
//
//            AddressBook newBook = new AddressBook();
//            newBook.addBuddy(buddy1);
//            newBook.addBuddy(buddy2);
//            newBook.addBuddy(buddy3);
//
//            repository.save(newBook);
//
//            log.info("AddressBook found with findAll():");
//            log.info("--------------------------------");
//            for (AddressBook book : repository.findAll()){
//                log.info("Book "+book.getId());
//                for (BuddyInfo buddy : book.getBuddies()){
//                    log.info("Name: "+ buddy.getName() + ", Phone: "+ buddy.getPhoneNumber());
//                }
//            }
//            log.info("");
//
//            AddressBook book = repository.findById(1L);
//            log.info("Book found with ID 1L:");
//            log.info("-----------------------");
//            for (BuddyInfo buddy : book.getBuddies()){
//                log.info("Name: "+ buddy.getName() + ", Phone: "+ buddy.getPhoneNumber());
//            }
//            log.info("");
//        };
//
//    }

//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository){
//        return (args) -> {
//            BuddyInfo buddy1 = new BuddyInfo("Jeff", "613-613-6133");
//            repository.save(buddy1);
//            repository.save(new BuddyInfo("Ethan", "613-613-9999"));
//            repository.save(new BuddyInfo("Ethan", "613-613-1111"));
//
//            log.info("BuddyInfos found with findAll():");
//            log.info("--------------------------------");
//            for (BuddyInfo buddy : repository.findAll()){
//                log.info("Name: "+ buddy.getName() + ", Phone: "+ buddy.getPhoneNumber());
//            }
//            log.info("");
//
//            BuddyInfo buddy = repository.findById(1L);
//            log.info("Buddy found with ID 1L:");
//            log.info("-----------------------");
//            log.info("Name: "+ buddy.getName() + ", Phone: "+ buddy.getPhoneNumber());
//
//            log.info("Buddy found with findByName of Ethan:");
//            log.info("-----------------------");
//            repository.findByName("Ethan").forEach(sample -> {
//                log.info("Name: "+ sample.getName() + ", Phone: "+ sample.getPhoneNumber());
//            });
//            log.info("");
//        };
//    }
//}
