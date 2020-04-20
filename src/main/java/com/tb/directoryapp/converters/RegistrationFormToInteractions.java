package com.tb.directoryapp.converters;


import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.model.Interactions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class RegistrationFormToInteractions implements Converter<RegistrationForm, Interactions> {

    @Override
    public Interactions convert(RegistrationForm registrationForm) {
        Interactions interactions = new Interactions();

        if (!StringUtils.isEmpty(registrationForm.getId()) && (registrationForm.getId() != null)) {
            interactions.setId(registrationForm.getId());
        }

        //  Updatable "USER" Attributes
        interactions.setTitle(registrationForm.getTitle());
        interactions.setFirstname(registrationForm.getFirstname());
        interactions.setLastname(registrationForm.getLastname());
        interactions.setPhoneNumber(registrationForm.getPhoneNumber());
        interactions.setDateOfBirth(registrationForm.getDateOfBirth());
        interactions.setGender(registrationForm.getGender());
        interactions.setUsername(registrationForm.getUsername());
        interactions.setEmail(registrationForm.getEmail());
        interactions.setPassword(registrationForm.getPassword());
        interactions.setPasswordSalt(registrationForm.getPasswordSalt());

        return interactions;
    }
}