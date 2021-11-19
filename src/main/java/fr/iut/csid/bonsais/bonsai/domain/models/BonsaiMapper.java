package fr.iut.csid.bonsais.bonsai.domain.models;

import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;

public class BonsaiMapper {

    public static Bonsai mapfromEntity(BonsaiEntity bonsaiEntity){
        return new Bonsai(bonsaiEntity.getId(),bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(),bonsaiEntity.getAcquisition_age());
    }

    public static Bonsai mapfromDTO(BonsaiDTO bonsaiDTO){
        return new Bonsai(null, bonsaiDTO.getName(), bonsaiDTO.getSpecies(),null, null,bonsaiDTO.getAcquisition_age());
    }
}
