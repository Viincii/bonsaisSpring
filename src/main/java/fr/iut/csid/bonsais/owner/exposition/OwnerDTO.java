package fr.iut.csid.bonsais.owner.exposition;

import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;

import java.util.List;
import java.util.UUID;

public class OwnerDTO {

    private UUID id;
    private String name;
    private List<BonsaiOwnerLightDTO> bonsais;

    public OwnerDTO() {
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

    public List<BonsaiOwnerLightDTO> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiOwnerLightDTO> bonsais) {
        this.bonsais = bonsais;
    }
}
