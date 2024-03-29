package com.codeup.blog.blog.models;


import com.codeup.blog.blog.models.Post;

import javax.persistence.*;

@Entity
@Table(name = "postimage")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String image_title;

    @Column(columnDefinition = "VARCHAR(1000) NOT NULL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImage(long id, String image_title, String url) {
        this.id = id;
        this.image_title = image_title;
        this.url = url;
    }

    public PostImage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost() {
        this.post = post;
    }
}