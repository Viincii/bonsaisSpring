package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;

public class BonsaiEntityMapper {

    public static BonsaiEntity mapfromBonsai(Bonsai bonsai){
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setStatus(bonsai.getStatus());
        bonsaiEntity.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiEntity.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiEntity.setId_owner(bonsai.getId_owner());
        bonsaiEntity.setLast_pruning(bonsai.getLast_pruning());
        bonsaiEntity.setLast_repotting(bonsai.getLast_repotting());
        bonsaiEntity.setLast_watering(bonsai.getLast_watering());
        return bonsaiEntity;
    }
}
