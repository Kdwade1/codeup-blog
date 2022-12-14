package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String breed;

    @Column (length =50, nullable = false)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="dog_vets",joinColumns = {@JoinColumn(name="dog_id")}, inverseJoinColumns = {@JoinColumn(name="vet_id")})
    private List<Vet>vets;

    public Dog(long id, String breed, String name, List<Toy> toys) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.toys = toys;
    }

    public Dog(String breed, String name, List<Toy> toys) {
        this.breed = breed;
        this.name = name;
        this.toys = toys;
    }

    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dog")
    private List<Toy> toys;
}
