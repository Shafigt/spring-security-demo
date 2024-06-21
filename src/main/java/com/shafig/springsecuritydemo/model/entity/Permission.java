package com.shafig.springsecuritydemo.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
