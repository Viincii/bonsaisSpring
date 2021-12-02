package fr.iut.csid.bonsais.bonsai.domain.models;


import java.util.UUID;

public class Bonsai {

    private UUID id;
    private String name;
    private String species;
    private String status;
    private String acquisition_date;
    private int acquisition_age;
    private UUID id_owner;
    private String last_pruning;
    private String last_watering;
    private String last_repotting;


    public Bonsai(UUID id, String name, String species, String status, String acquisition_date, int acquisition_age, UUID id_owner, String last_pruning, String last_repotting, String last_watering) {
        this.id=id;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
        this.id_owner = id_owner;
        this.last_pruning= last_pruning;
        this.last_repotting = last_repotting;
        this.last_watering = last_watering;
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

    public UUID getId_owner() {
        return id_owner;
    }

    public String getLast_pruning() {
        return last_pruning;
    }

    public String getLast_watering() {
        return last_watering;
    }

    public String getLast_repotting() {
        return last_repotting;
    }
}