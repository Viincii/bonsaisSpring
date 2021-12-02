package fr.iut.csid.bonsais.bonsai.infrastructure;

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

    @Column(name = "id_owner")
    private UUID id_owner;

    @Column(name = "last_pruning")
    private String last_pruning;

    @Column(name = "last_watering")
    private String last_watering;

    @Column(name = "last_repotting")
    private String last_repotting;


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

    public UUID getId_owner() {
        return id_owner;
    }

    public void setId_owner(UUID id_owner) {
        this.id_owner = id_owner;
    }

    public String getLast_pruning() {
        return last_pruning;
    }

    public void setLast_pruning(String last_pruning) {
        this.last_pruning = last_pruning;
    }

    public String getLast_watering() {
        return last_watering;
    }

    public void setLast_watering(String last_watering) {
        this.last_watering = last_watering;
    }

    public String getLast_repotting() {
        return last_repotting;
    }

    public void setLast_repotting(String last_repotting) {
        this.last_repotting = last_repotting;
    }
}
