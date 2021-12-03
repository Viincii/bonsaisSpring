package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Pruning;

public class PruningDTOMapper {

    public static PruningDTO mapFromPruning(Pruning pruning){
        PruningDTO pruningDTO = new PruningDTO();
        pruningDTO.setId_pruning(pruning.getId_pruning());
        pruningDTO.setDate(pruning.getDate().toString().replaceAll("T", " "));
        return pruningDTO;
    }
}
