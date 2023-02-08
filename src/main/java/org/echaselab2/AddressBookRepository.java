package org.echaselab2;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository  extends CrudRepository<AddressBook, Integer> {
    AddressBook findById(Long id);
}
