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


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> image;


    @ManyToMany(mappedBy = "post")
    private List<Tag> tag;


    public Post() {
    }

    public Post(String title, String description, User user, List<PostImage> image, List<Tag> tag) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.image = image;
        this.tag = tag;
    }


    public Post(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
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


    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public List<PostImage> getImage() {
        return image;
    }

    public void setImage(List<PostImage> image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //    public List<PostImage> getImages () {
//        return imag es;
//    }
//    public void setImages(List<PostImage> image){
//        this.images = image;
//    }
}
