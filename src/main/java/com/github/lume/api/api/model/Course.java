package com.github.lume.api.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Double evaluation;

    @Column(nullable = false)
    private Integer workload;

    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] cover;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules;

    public Course() {}

    public void addUser(User user) {
        users.add(user);
    }

    public Course(String name, String description, Double evaluation, Integer workload, byte[] cover) {
        this.name = name;
        this.description = description;
        this.evaluation = evaluation;
        this.workload = workload;
        this.cover = cover;
    }

    // ...existing code...
}