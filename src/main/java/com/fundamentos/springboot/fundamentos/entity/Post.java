package com.fundamentos.springboot.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    public Long id;

    @Column(name = "description", length = 255)
    public String description;
}
