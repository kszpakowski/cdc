package com.kszpakowski.cdc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "`user`")
@Audited
public class User extends BaseEntity {

    private String firstname;
    private String lastname;

    @Version
    private Long version;

//    @OneToMany
//    private Address address;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}