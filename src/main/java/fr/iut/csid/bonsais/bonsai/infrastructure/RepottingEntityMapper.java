package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Repotting;

public class RepottingEntityMapper {

    public static RepottingEntity mapFromRepotting(Repotting repotting){
        RepottingEntity repottingEntity = new RepottingEntity();
        repottingEntity.setId_repotting(repotting.getId_repotting());
        repottingEntity.setDate(repotting.getDate());
        repottingEntity.setBonsai(BonsaiEntityMapper.mapfromBonsai(repotting.getBonsai()));
        return repottingEntity;
    }
}
