package com.tb.directoryapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "portal_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Travelbetadmin {

    // Attributes of User (i.e User Credentials)...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(unique = true)
    private String username;
    @Digits(fraction = 0, integer = 11)
    private Long phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String passwordHashAlgorithm;
    private String passwordSalt;
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    private String status;
    private boolean passwordReset;
    private boolean enabled;
    @Transient
    private boolean credentialsNonExpired = true;
    @Transient
    private boolean accountNonExpired = true;
    @Transient
    private boolean accountNonLocked = true;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_fk")
    private Role role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Travelbetadmin ))
            return false;
        return id != null && id.equals(((Travelbetadmin) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}





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
//    public boolean isNew() {
//        return this.id == null;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstName) {
//        this.firstname = firstName;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastName) {
//        this.lastname = lastName;
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