package com.tb.directoryapp.services;


import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.model.Travelbetadmin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface TravelbetadminService extends UserDetailsService {

    Travelbetadmin findByUsernameIgnoreCase(String username);

    Travelbetadmin findByEmailIgnoreCase(String email);

    Travelbetadmin findByEmail(String email);

    List<Travelbetadmin> listAll();

    Travelbetadmin getById(Long id);

    Travelbetadmin saveOrUpdate(Travelbetadmin travelbetadmin);

    void delete(Long id);

    Travelbetadmin saveOrUpdateRegistrationForm(RegistrationForm registrationForm);

}


