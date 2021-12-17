package fr.iut.csid.bonsais.bonsai.domain.models;

import fr.iut.csid.bonsais.common.PruningEntity;

public class PruningMapper {

    public static Pruning mapFromEntity(PruningEntity pruningEntity){
        return new Pruning(pruningEntity.getId_pruning(), pruningEntity.getDate(), BonsaiMapper.mapfromEntity(pruningEntity.getBonsai()));
    }
}
