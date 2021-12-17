package fr.iut.csid.bonsais.owner.domain.models;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;

import java.util.List;
import java.util.UUID;

public class Owner {

    private UUID uuid;
    private String name;
    private List<Bonsai> bonsais;

    public Owner(UUID uuid, String name, List<Bonsai> bonsais) {
        this.uuid = uuid;
        this.name = name;
        this.bonsais = bonsais;
    }

    public Owner() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bonsai> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<Bonsai> bonsais) {
        this.bonsais = bonsais;
    }
}
