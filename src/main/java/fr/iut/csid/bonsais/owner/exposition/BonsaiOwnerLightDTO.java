package fr.iut.csid.bonsais.owner.exposition;

import java.util.UUID;

public class BonsaiOwnerLightDTO {

    private UUID id;
    private String name;
    private String species;
    private int acquisition_age;

    public BonsaiOwnerLightDTO(UUID id, String name, String species, int acquisition_age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.acquisition_age = acquisition_age;
    }

    public BonsaiOwnerLightDTO() {
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
}
