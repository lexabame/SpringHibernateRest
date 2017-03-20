package com.alex.login.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alejandro on 8/20/16.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name ="FIRST_NAME")
    private String firstName;

    @Column(name ="LAST_NAME")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "FK_ACCOUNT_ID")
    private AccountEntity account;

    @Column(name ="CREATION_DATE")
    //@Type(type = "dateTimeUserType")
    private Date creationDate;

    @Column(name ="MODIFICATION_DATE")
    //@Type(type = "dateTimeUserType")
    private Date modificationDate;

}
