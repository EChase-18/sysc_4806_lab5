package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressBookViewController {
    @Autowired
    private AddressBookRepository bookRepository;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll().toString());
        return "dummy";
    }
}
