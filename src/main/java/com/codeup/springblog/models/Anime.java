package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 30)
    private String title;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean sucks;

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

    public boolean isSucks() {
        return sucks;
    }

    public void setSucks(boolean sucks) {
        this.sucks = sucks;
    }

    public Anime() {
    }

    public Anime(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Anime(String title, String description, boolean sucks) {
        this.title = title;
        this.description = description;
        this.sucks = sucks;
    }

    public Anime(Long id, String title, String description, boolean sucks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.sucks = sucks;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
