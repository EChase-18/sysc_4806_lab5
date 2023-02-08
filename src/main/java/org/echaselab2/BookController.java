package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BookController {
    @Autowired
    private AddressBookRepository bookRepository;

    @RequestMapping(value = "/book", method=POST)
    public Long createBook(){
        AddressBook newBook = new AddressBook();
        bookRepository.save(newBook);
        return newBook.getId();
    }
}
