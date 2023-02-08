package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceS  implements AddressBookService{
    @Autowired
    private AddressBookRepository bookRepository;

    @Override
    public AddressBook createAddressBook() {
        return bookRepository.save(new AddressBook());
    }

    @Override
    public AddressBook getAddressBook(Long id) {
        return bookRepository.findById(id);
    }
}
