package com.example.servingwebcontent.app;

import com.example.servingwebcontent.app.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressBookRepository extends CrudRepository<AddressBook,Long> {
    AddressBook findById(long id);

    List<AddressBook> findAll();

}
