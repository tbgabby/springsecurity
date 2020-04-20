package com.tb.directoryapp.services;


import com.tb.directoryapp.enumeration.RoleType;
import com.tb.directoryapp.model.Role;
import com.tb.directoryapp.model.Travelbetadmin;
import com.tb.directoryapp.repositories.TravelbetadminRepository;
import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.converters.RegistrationFormToTravelbetadmin;
import com.tb.directoryapp.repositories.RoleRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TravelbetadminServiceImpl implements TravelbetadminService {

    private TravelbetadminRepository travelbetadminRepository;
    private RegistrationFormToTravelbetadmin registrationFormToTravelbetadmin;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TravelbetadminServiceImpl(TravelbetadminRepository travelbetadminRepository, RegistrationFormToTravelbetadmin registrationFormToTravelbetadmin, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.travelbetadminRepository = travelbetadminRepository;
        this.registrationFormToTravelbetadmin = registrationFormToTravelbetadmin;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override    // Will prevent Duplicate "Username" Entries
    public Travelbetadmin findByUsernameIgnoreCase(String username) {
        return travelbetadminRepository.findByUsernameIgnoreCase(username);
    }

    @Override   // Will prevent Duplicate "Email" Entries
    public Travelbetadmin findByEmailIgnoreCase(String email) {
        return travelbetadminRepository.findByEmailIgnoreCase(email);
    }

    @Override   // "Find User's Email for "Mail-Sender".
    public Travelbetadmin findByEmail(String email) {
        return travelbetadminRepository.findByEmail(email);
    }

    @Override  //  www.travelbeta.com/adminstrator/users
               //  Show a List of all USERS:
    public List<Travelbetadmin> listAll() {
        List<Travelbetadmin> travelbetadmins = new ArrayList<>();
        travelbetadminRepository.findAll().forEach(travelbetadmins::add);
        return travelbetadmins;
    }

    @Override     //  www.travelbeta.com/adminstrator/view/{id}
                  //  Find "USERS" by their Unique ID:
    public Travelbetadmin getById(Long id) {
        return travelbetadminRepository.findById(id).orElse(null);
    }

    @Override     // www.travelbeta.com/registration        (Un-comment out all setters-&-getters for each attribute of User to allow "Online Registration" Work!)
                  // www.travelbeta.com/adminstrator/users  (Comment out all setters-&-getters for each attribute of User to allow "RegistrationFormToUser" Work!)
    public Travelbetadmin saveOrUpdate(Travelbetadmin travelbetadmin) {
//            travelbetadmin.setId(travelbetadmin.getId());
//            travelbetadmin.setTitle(travelbetadmin.getTitle());
//            travelbetadmin.setFirstname(travelbetadmin.getFirstname());
//            travelbetadmin.setLastname(travelbetadmin.getLastname());
//            travelbetadmin.setUsername(travelbetadmin.getUsername());
//            travelbetadmin.setPhoneNumber(travelbetadmin.getPhoneNumber());
//            travelbetadmin.setDateOfBirth(travelbetadmin.getDateOfBirth());
//            travelbetadmin.setGender(travelbetadmin.getGender());
//            travelbetadmin.setEmail(travelbetadmin.getEmail());
//            travelbetadmin.setPassword(passwordEncoder.encode(travelbetadmin.getPassword()));
//            travelbetadmin.setPasswordHashAlgorithm("Bcrypt");
//            travelbetadmin.setPasswordSalt(passwordEncoder.encode(travelbetadmin.getPasswordSalt()));
//            travelbetadmin.setLastUpdate(travelbetadmin.getLastUpdate());
//            travelbetadmin.setDateCreated(travelbetadmin.getDateCreated());
//            travelbetadmin.setStatus("ACTIVATED");
//            travelbetadmin.setEnabled(true);
//            travelbetadmin.setCredentialsNonExpired(true);
//
//        Role TRAVEL_CONSULTANT_SUPERVISOR = roleRepository.getRoleByName(RoleType.TRAVEL_CONSULTANT_SUPERVISOR.getName());
//            travelbetadmin.setRole(TRAVEL_CONSULTANT_SUPERVISOR);
//
//            System.out.println("*** ONLINE REGISTRATION ***" +"\n" +
//                    "S/N: No." + travelbetadmin.getId() + "\n" +
//                    "Username: " + travelbetadmin.getUsername()  + "\n" +
//                    "Email: " + travelbetadmin.getEmail()  + "\n" +
//                    "Enabled: " + travelbetadmin.isEnabled()  + "\n" +
//                    "[ROLE: " + travelbetadmin.getRole() + "]");

         travelbetadminRepository.save(travelbetadmin);
         return travelbetadmin;
    }

    @Override    //  www.travelbeta.com/adminstrator/delete/{id}
                 //  Delete a "USER" by it's Unique ID:
    public void delete(Long id) {
        travelbetadminRepository.deleteById(id);
    }

    @Override    //  www.travelbeta.com/adminstrator/user
                 //  Create & Update a "USER" Account:
    public Travelbetadmin saveOrUpdateRegistrationForm(RegistrationForm registrationForm) {
        Travelbetadmin savedTravelbetadmin = saveOrUpdate(registrationFormToTravelbetadmin.convert(registrationForm));

        System.out.println("*** CREATE ACCOUNT [Admin] ***" +"\n" +
                            "S/N: No." + savedTravelbetadmin.getId() + " ***" + "\n" +
                            "FirstName: " + savedTravelbetadmin.getFirstname()  + "\n" +
                            "LastName: " + savedTravelbetadmin.getLastname()  + "\n" +
                            "PhoneNumber: " + savedTravelbetadmin.getPhoneNumber()  + "\n" +
                            "Username: " + savedTravelbetadmin.getUsername() + "\n" +
                            "Email: " + savedTravelbetadmin.getEmail() + "\n" +
                            "Date Created: " + savedTravelbetadmin.getDateCreated() + "\n" +
                            "Enabled: " + savedTravelbetadmin.isEnabled() + "\n" +
                            "Credentials Still Valid: " + savedTravelbetadmin.isCredentialsNonExpired() + "\n" +
                            "[ROLE: " + savedTravelbetadmin.getRole() + "]");

        return savedTravelbetadmin;
    }

    @Override         // www.travelbeta.com/auth/login
    @Transactional    // Login Credentials:  Username & Password.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Travelbetadmin travelbetadmin = travelbetadminRepository.findByUsernameIgnoreCase(username);

        if (travelbetadmin == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // Change user.getUsername() to user.getFirstName() to change greeting on CRM Page from "Welcome 'username'" to "Welcome 'firstName'"
        return new org.springframework.security.core.userdetails.User(
                travelbetadmin.getUsername(), travelbetadmin.getPassword(), grantedAuthorities
        );
    }
}