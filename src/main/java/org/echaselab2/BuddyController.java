package org.echaselab2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class BuddyController {
    @Autowired
    private BuddyInfoRepository buddyRepository;

    @Autowired
    private AddressBookRepository bookRepository;

    @RequestMapping(value = "/buddy", method=POST)
    public void addBuddy(@RequestParam(name = "book") Long id, @RequestParam(name = "buddy_name") String name, @RequestParam(name = "buddy_phone") String phone){
        BuddyInfo newBuddy = new BuddyInfo();
        newBuddy.setName(name);
        newBuddy.setPhoneNumber(phone);

        buddyRepository.save(newBuddy);

        AddressBook currBook = bookRepository.findById(id);
        currBook.addBuddy(newBuddy);

        bookRepository.save(currBook);
    }

    @RequestMapping(value = "/buddy", method=DELETE)
    public String deleteBuddy(@RequestParam(name = "id") Long id,@RequestParam(name = "name") String name){
        AddressBook currBook = bookRepository.findById(id);

        for (BuddyInfo buddy : currBook.getBuddies()){
            if (buddy.getName().equals(name)){
                currBook.removeBuddy(buddy);
                bookRepository.save(currBook);
                buddyRepository.delete(buddy);
                return buddy.getName();
            }
        }

        return "";
    }
}
