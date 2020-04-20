package com.tb.directoryapp.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Interactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    private Date dateOfBirth;
    private String username;
    private Long phoneNumber;
    private String email;
    private String password;
    private String passwordSalt;

    //    public void setPassword(String password) {
    //        this.password = password;
    //    }
    //
    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public void setId(Long id) {
    //        this.id = id;
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
    //        return lastname;
    //    }
    //
    //    public void setLastname(String lastname) {
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
    //    public String getPasswordSalt() {
    //        return passwordSalt;
    //    }
    //
    //    public void setPasswordSalt(String passwordSalt) {
    //        this.passwordSalt = passwordSalt;
    //    }

}
