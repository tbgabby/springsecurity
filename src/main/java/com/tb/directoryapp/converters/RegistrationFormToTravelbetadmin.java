package com.tb.directoryapp.converters;


import com.tb.directoryapp.enumeration.RoleType;
import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.model.Role;
import com.tb.directoryapp.model.Travelbetadmin;
import com.tb.directoryapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


// For Creating Account :    Www.travelbeta.com/adminstrator/user
// For Updating Account :    Www.travelbeta.com/update/{id}
@Component     // REQUIRED COMPONENT
public class RegistrationFormToTravelbetadmin implements Converter<RegistrationForm, Travelbetadmin> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Travelbetadmin convert(RegistrationForm registrationForm) {
        Travelbetadmin travelbetadmin = new Travelbetadmin();
        Role SUPER_ADMIN = roleRepository.getRoleByName(RoleType.SUPER_ADMIN.getName());

        if (registrationForm.getId() != null  && !StringUtils.isEmpty(registrationForm.getId())) {
            travelbetadmin.setId(registrationForm.getId());
        }

        travelbetadmin.setTitle(registrationForm.getTitle());
        travelbetadmin.setFirstname(registrationForm.getFirstname());
        travelbetadmin.setLastname(registrationForm.getLastname());
        travelbetadmin.setUsername(registrationForm.getUsername());
        travelbetadmin.setPhoneNumber(registrationForm.getPhoneNumber());
        travelbetadmin.setDateOfBirth(registrationForm.getDateOfBirth());
        travelbetadmin.setGender(registrationForm.getGender());
        travelbetadmin.setEmail(registrationForm.getEmail());
        travelbetadmin.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        travelbetadmin.setPasswordHashAlgorithm("Bcrypt");
        travelbetadmin.setPasswordSalt(passwordEncoder.encode(registrationForm.getPasswordSalt()));
        travelbetadmin.setLastUpdate(registrationForm.getLastUpdate());
        travelbetadmin.setDateCreated(registrationForm.getDateCreated());
        travelbetadmin.setStatus("ACTIVATED");
        travelbetadmin.setPasswordReset(false);
        travelbetadmin.setEnabled(true);
        travelbetadmin.setRole(SUPER_ADMIN);

        return travelbetadmin;
    }
}