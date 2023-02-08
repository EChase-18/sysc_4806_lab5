package org.echaselab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuddyInfoViewController {
    @Autowired
    private BuddyInfoRepository buddyRepository;

    @RequestMapping(value = "/buddy", method = RequestMethod.GET)
    public String getBuddies(Model model){
        model.addAttribute("buddies", buddyRepository.findAll().toString());
        return "dummy2";
    }
}