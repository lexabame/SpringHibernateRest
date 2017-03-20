package com.alex.login.rest.data;

import com.alex.login.dao.entities.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by alejandro on 3/19/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountCanonical {

    @XmlElement(name = "id")
    private Long id;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "secret")
    private String secret;

    @XmlElement(name = "role")
    private String role;

    @XmlElement(name = "status")
    private Boolean status;

    @XmlElement(name = "creationDate")
    private Date creationDate;

    @XmlElement(name = "modificationDate")
    private Date modificationDate;
}
