package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 200)
    private String title;
    @Column(nullable = false)
    private String description;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> image;

    public Post() {
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Post(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<PostImage> getImage() {
        return image;
    }

    public void setImage(List<PostImage> image) {
        this.image = image;
    }
//    public List<PostImage> getImages () {
//        return imag es;
//    }
//    public void setImages(List<PostImage> image){
//        this.images = image;
//    }
}
