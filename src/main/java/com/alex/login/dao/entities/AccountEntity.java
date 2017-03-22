package com.alex.login.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alejandro on 3/18/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name ="EMAIL")
    private String email;

    @Column(name ="SECRET")
    private String secret;

    @Column(name ="ROLE")
    private String role;

    @Column(name ="ACTIVE")
    private Boolean active;

    @Column(name ="creation_date")
    //@Type(type = "dateTimeUserType")
    private Date creationDate;

    @Column(name ="MODIFICATION_DATE")
    //@Type(type = "dateTimeUserType")
    private Date modificationDate;

}
