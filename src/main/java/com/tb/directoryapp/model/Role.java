package com.tb.directoryapp.model;


import com.tb.directoryapp.enumeration.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private String displayName;


    public Role(RoleType roleType) {
        this.name = roleType.getName();
        this.description = roleType.getName();
        this.displayName = roleType.getName();
    }

}
