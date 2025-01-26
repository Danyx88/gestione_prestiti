package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Birth;
    @Column(nullable = false, unique = true)
    private long Tessera;

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }

    public long getTessera() {
        return Tessera;
    }

    public void setTessera(long tessera) {
        Tessera = tessera;
    }
}
