package com.tb.directoryapp.services;

import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.converters.RegistrationFormToInteractions;
import com.tb.directoryapp.model.Interactions;
import com.tb.directoryapp.repositories.InteractionsRepository;
import org.springframework.stereotype.Service;


@Service
public class InteractionsServiceImpl implements InteractionsService {
    private InteractionsRepository interactionsRepository;
    private RegistrationFormToInteractions RegistrationFormToInteractions;

    public InteractionsServiceImpl(InteractionsRepository interactionsRepository, RegistrationFormToInteractions RegistrationFormToInteractions) {
        this.interactionsRepository = interactionsRepository;
        this.RegistrationFormToInteractions = RegistrationFormToInteractions;
    }

    @Override
    public Interactions saveOrUpdate(Interactions interactions) {
        return interactionsRepository.save(interactions);
    }

    @Override
    public void saveOrUpdateContactForm(RegistrationForm registrationForm) {

        Interactions savedContact = saveOrUpdate(RegistrationFormToInteractions.convert(registrationForm));

        System.out.println("***Saved Interactions as S/N: " + savedContact.getId() + " ***");
    }

}
