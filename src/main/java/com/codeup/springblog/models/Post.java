package com.codeup.springblog.models;

import com.codeup.springblog.repositories.PostRepository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="blog")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 30)
    private String title;
    @Column(nullable = false,length = 100)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="post_tag", joinColumns = {@JoinColumn(name="post_id")},inverseJoinColumns = {@JoinColumn(name="tag_id")})
    private List<Tag> tags;

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    public Post() {
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {

        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
