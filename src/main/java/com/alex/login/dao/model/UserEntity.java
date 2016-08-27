package com.alex.login.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by alejandro on 8/20/16.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "secret")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_ame")
    private String lastName;

    @Column(name = "role")
    private String role;
}
