package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;

public class BonsaiDTOMapper {

    public static BonsaiDTO mapFromBonsai(Bonsai bonsai){
        BonsaiDTO dto = new BonsaiDTO();
        dto.setName(bonsai.getName());
        dto.setSpecies(bonsai.getSpecies());
        dto.setAcquisition_age(bonsai.getAcquisition_age());
        return dto;
    }
}