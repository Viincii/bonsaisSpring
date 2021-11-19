package fr.iut.csid.bonsais;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "status")
    private String status;

    @Column(name = "acquisition_date")
    private String acquisition_date;

    @Column(name = "acquisition_age")
    private int acquisition_age;


    public BonsaiEntity(){

    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }
}
