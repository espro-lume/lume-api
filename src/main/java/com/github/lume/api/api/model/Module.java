package com.github.lume.api.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;
}
