package com.midas.auth.entity;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "userTable")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "isActive")
    private Boolean isActive;



}
