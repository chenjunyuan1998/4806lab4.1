package com.example.servingwebcontent.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    @GetMapping("/BuddyInfo")
    public BuddyInfo buddyInfo(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone) {
        return new BuddyInfo(name,address,phone);
    }

    @GetMapping("/AddressBook")
    public AddressBook addressBook(){
        return new AddressBook();
    }
}
