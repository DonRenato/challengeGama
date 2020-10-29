package com.thejavinhos.tvchannel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "password")
    private int password;
    @Column(name = "username")
    private String username;




}
