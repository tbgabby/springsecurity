package com.tb.directoryapp.repositories;


import com.tb.directoryapp.model.Travelbetadmin;
import org.springframework.data.repository.CrudRepository;


public interface TravelbetadminRepository extends CrudRepository<Travelbetadmin, Long> {

    // Prevents Duplicate E-mail Entries.
    Travelbetadmin findByEmailIgnoreCase(String email);

    // Prevents Duplicate Username Entries.
    Travelbetadmin findByUsernameIgnoreCase(String username);

    // Find USER E-mail for MailSender.
    Travelbetadmin findByEmail(String email);

    //    Travelbetadmin findByUsername(String username);

}
