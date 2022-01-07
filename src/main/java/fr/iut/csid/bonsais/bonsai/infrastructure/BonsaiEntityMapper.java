package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.common.BonsaiEntity;

public class BonsaiEntityMapper {

    public static BonsaiEntity mapfromBonsai(Bonsai bonsai){
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setStatus(bonsai.getStatus());
        bonsaiEntity.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiEntity.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiEntity.setOwner(/*bonsai.getOwner()*/null);
        return bonsaiEntity;
    }
}
