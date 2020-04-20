package com.tb.directoryapp.converters;

import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.model.Travelbetadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component     // REQUIRED COMPONENT
public class TravelbetadminToRegistrationForm implements Converter<Travelbetadmin, RegistrationForm> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public RegistrationForm convert(Travelbetadmin travelbetadmin) {
        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm.setId(travelbetadmin.getId());
        registrationForm.setTitle(travelbetadmin.getTitle());
        registrationForm.setFirstname(travelbetadmin.getFirstname());
        registrationForm.setLastname(travelbetadmin.getLastname());
        registrationForm.setUsername(travelbetadmin.getUsername());
        registrationForm.setPhoneNumber(travelbetadmin.getPhoneNumber());
        registrationForm.setDateOfBirth(travelbetadmin.getDateOfBirth());
        registrationForm.setGender(travelbetadmin.getGender());
        registrationForm.setEmail(travelbetadmin.getEmail());
        registrationForm.setPassword(passwordEncoder.encode(travelbetadmin.getPassword()));
        registrationForm.setPasswordHashAlgorithm(travelbetadmin.getPasswordHashAlgorithm());
        registrationForm.setPasswordSalt(passwordEncoder.encode(travelbetadmin.getPasswordSalt()));
        registrationForm.setLastUpdate(travelbetadmin.getLastUpdate());
        registrationForm.setDateCreated(travelbetadmin.getDateCreated());
        registrationForm.setStatus(travelbetadmin.getStatus());
        registrationForm.setPasswordReset(travelbetadmin.isPasswordReset());
        registrationForm.setEnabled(travelbetadmin.isEnabled());
        registrationForm.setRole(travelbetadmin.getRole());

        return registrationForm;
    }
}