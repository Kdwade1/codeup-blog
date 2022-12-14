package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=50)
    private String name;

    @ManyToOne
    @JoinColumn
    private Dog dog;

    public Toy(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Toy() {
    }

}
