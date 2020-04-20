package com.tb.directoryapp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="account_creation_request")
@Data
@NoArgsConstructor
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="activation_code")
    private String confirmationToken;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @CreationTimestamp
    private LocalDateTime dateActivated;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //    @JoinColumn(name = "id")
    @JoinColumn(nullable = false, name = "id")
    private Travelbetadmin travelbetadmin;

    ////////////////////////////////////////////////////////////////////////

    public ConfirmationToken(Travelbetadmin travelbetadmin) {
        this.travelbetadmin = travelbetadmin;
        confirmationToken = UUID.randomUUID().toString();
    }

}




















//    @Column(name = "id")
//    private long tokenid;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dateCreated;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dateActivated;
//
//public ConfirmationToken(Travelbetadmin travelbetadmin) {
//    this.travelbetadmin = travelbetadmin;
//    dateCreated = new Date();
//    dateActivated = new Date();
//    confirmationToken = UUID.randomUUID().toString();
//}