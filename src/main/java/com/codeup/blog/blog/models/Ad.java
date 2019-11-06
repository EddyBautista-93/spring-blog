package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;


    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
// equivalent to
//CREATE TABLE ads (
//        id BIGINT NOT NULL AUTO_INCREMENT,
//        title VARCHAR(100) NOT NULL,
//    description VARCHAR(255) NOT NULL,
//    PRIMARY KEY (id)
//);