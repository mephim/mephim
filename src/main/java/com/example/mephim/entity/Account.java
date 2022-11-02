package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "register_date", columnDefinition = "DATE")
    private String registerDate;

    @Column(name = "verification_code", columnDefinition = "varchar(100)")
    private String verificationCode;

    @Column(name = "provider", columnDefinition = "VARCHAR(20)")
    private String provider;

    @Column(name = "is_enable", columnDefinition = "bit(1)")
    private Boolean isEnable;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> roles;

    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private User user;
}
