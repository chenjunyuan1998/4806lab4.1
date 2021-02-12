package com.example.servingwebcontent.app;

import com.example.servingwebcontent.app.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class BuddyController {
    @Autowired
    AddressBookRepository repository;
    @GetMapping("/result")
    public String addAddressBook(Model model) {
        model.addAttribute("addressBook", repository.findAll());
        return "result";
    }
}