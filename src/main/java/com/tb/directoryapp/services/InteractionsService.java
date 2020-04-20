package com.tb.directoryapp.services;

import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.model.Interactions;


public interface InteractionsService {

    Interactions saveOrUpdate(Interactions interactions);

    void saveOrUpdateContactForm(RegistrationForm registrationForm);

}
