package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = {@JoinColumn(name="tag_id")},
            inverseJoinColumns = {@JoinColumn(name="post_id")}
    )
private List<Post> post;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, List<Post> post) {
        this.name = name;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
