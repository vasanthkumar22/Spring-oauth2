package com.example.userauth.oauth2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ENDUSER")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "USERNAME", unique = true, length = 100, nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotNull
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
        private Set<Role> roles;

}
