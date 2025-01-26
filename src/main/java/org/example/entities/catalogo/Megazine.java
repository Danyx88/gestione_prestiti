package org.example.entities.catalogo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Megazine")

public class Megazine extends Biblioteca {

    @Column(nullable = false)
    private String periodic;

    public Megazine() {}

    public String getPeriodic() {
        return periodic;
    }

    public void setPeriodic(String periodic) {
        this.periodic = periodic;
    }


}
