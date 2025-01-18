package com.demo.snowflake.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonModel {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "USERS_SEQUENCE")
    @SequenceGenerator( name = "USERS_SEQUENCE" , sequenceName = "USERS_SEQUENCE")
    private Long id;

    @Column(name = "EMAIL")
    private String email;
}
