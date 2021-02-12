package com.example.servingwebcontent;
import com.example.servingwebcontent.app.AddressBook;
import com.example.servingwebcontent.app.AddressBookRepository;
import com.example.servingwebcontent.app.BuddyInfo;
import com.example.servingwebcontent.app.BuddyInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository, AddressBookRepository repository1) {
        return (args) -> {
            // save a few customers
            BuddyInfo b1 = new BuddyInfo("Jack", "assada", "sassa121sa");
            BuddyInfo b2 = new BuddyInfo("Jasadck", "assadsada", "sassasad121sa");
            AddressBook a = new AddressBook();
            a.addBuddy(b1);
            a.addBuddy(b2);
            repository1.save(a);

        };
    }


}