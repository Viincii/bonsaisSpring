package fr.iut.csid.bonsais.bonsai.domain.models;


import java.util.UUID;

public class Bonsai {

    private UUID id;
    private String name;
    private String species;
    private String status;
    private String acquisition_date;
    private int acquisition_age;

    public Bonsai(UUID id, String name, String species, String status, String acquisition_date, int acquisition_age) {
        this.id=id;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getStatus() {
        return status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public UUID getId() {
        return id;
    }
}