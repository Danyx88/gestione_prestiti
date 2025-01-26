package org.example.entities.catalogo;

import org.example.entities.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "elementoID", nullable = false)
    private Biblioteca biblioteca;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date inizioPrestito;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finePrestito;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date restituzione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Date getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(Date inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public Date getFinePrestito() {
        return finePrestito;
    }

    public void setFinePrestito(Date finePrestito) {
        this.finePrestito = finePrestito;
    }

    public Date getRestituzione() {
        return restituzione;
    }

    public void setRestituzione(Date restituzione) {
        this.restituzione = restituzione;
    }
}
