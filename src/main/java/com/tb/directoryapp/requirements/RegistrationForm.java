package com.tb.directoryapp.requirements;


import com.tb.directoryapp.model.Role;
import lombok.Data;

import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.Date;
//import java.util.Date;


@Data
public class RegistrationForm {

    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    private Date dateOfBirth;
    private String username;
    @Digits(fraction = 0, integer = 11)
    private Long phoneNumber;
    private String email;
    private String password;
    private String passwordHashAlgorithm;
    private String passwordSalt;
    private LocalDateTime lastUpdate;
    private LocalDateTime dateCreated;
    private String confirmationToken;
    private String status;
    private boolean passwordReset;
    private boolean enabled;
    private Role role;


    public boolean isNew() {
        return this.id == null;
    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public boolean isNew() {
//        return this.id == null;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//
//        this.lastname = lastname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Long getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(Long phoneNumber) {
//
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPasswordSalt() {
//        return passwordSalt;
//    }
//
//    public void setPasswordSalt(String passwordSalt) {
//        this.passwordSalt = passwordSalt;
//    }


}


