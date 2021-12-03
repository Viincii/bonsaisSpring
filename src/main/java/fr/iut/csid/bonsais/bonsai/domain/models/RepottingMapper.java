package fr.iut.csid.bonsais.bonsai.domain.models;

import fr.iut.csid.bonsais.bonsai.infrastructure.RepottingEntity;

public class RepottingMapper {

    public static Repotting mapFromEntity(RepottingEntity repottingEntity){
        return new Repotting(repottingEntity.getId_repotting(), repottingEntity.getDate(), BonsaiMapper.mapfromEntity(repottingEntity.getBonsai()));
    }
}
