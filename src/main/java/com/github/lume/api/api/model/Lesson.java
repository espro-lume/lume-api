package com.github.lume.api.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private byte[] file;

    @Column(nullable = true)
    private String url;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    public Lesson() {
    }

    public Lesson(String name) {
        this.name = name;
    }
}
