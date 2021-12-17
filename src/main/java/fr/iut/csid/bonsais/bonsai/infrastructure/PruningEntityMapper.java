package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Pruning;
import fr.iut.csid.bonsais.common.PruningEntity;

public class PruningEntityMapper {

    public static PruningEntity mapFromPruning(Pruning pruning){
        PruningEntity pruningEntity = new PruningEntity();
        pruningEntity.setId_pruning(pruning.getId_pruning());
        pruningEntity.setDate(pruning.getDate());
        pruningEntity.setBonsai(BonsaiEntityMapper.mapfromBonsai(pruning.getBonsai()));
        return pruningEntity;
    }
}
