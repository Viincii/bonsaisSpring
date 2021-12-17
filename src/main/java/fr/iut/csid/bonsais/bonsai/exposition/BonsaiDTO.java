package fr.iut.csid.bonsais.bonsai.exposition;

import java.util.UUID;

public class BonsaiDTO {
    private UUID id;
    private String name;
    private String species;
    private int acquisition_age;
    private String acquisition_date;
    private String last_pruning;
    private String last_watering;
    private String last_repotting;
    private Status status;


    public BonsaiDTO() {
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

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }
}
