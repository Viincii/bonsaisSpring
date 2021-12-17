package fr.iut.csid.bonsais.bonsai.domain.models;

import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;

import java.util.Date;

public class BonsaiMapper {

    public static Bonsai mapfromEntity(BonsaiEntity bonsaiEntity){
        Date lastWatering;
        if (bonsaiEntity.getListWatering()== null || bonsaiEntity.getListWatering().isEmpty()) {
            lastWatering = null;
        }
        else
            lastWatering = bonsaiEntity.getListWatering().get(0).getDate();
        Date lastPruning;
        if (bonsaiEntity.getListPruning() == null || bonsaiEntity.getListPruning().isEmpty())
            lastPruning = null;
        else
            lastPruning = bonsaiEntity.getListPruning().get(0).getDate();
        Date lastRepotting;
        if (bonsaiEntity.getListRepotting() == null || bonsaiEntity.getListRepotting().isEmpty())
            lastRepotting = null;
        else
            lastRepotting = bonsaiEntity.getListRepotting().get(0).getDate();
        return new Bonsai(bonsaiEntity.getId(),bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(), bonsaiEntity.getAcquisition_age(), null, lastWatering, lastPruning, lastRepotting);
    }

    public static Bonsai mapfromDTO(BonsaiDTO bonsaiDTO){
        return new Bonsai(bonsaiDTO.getId(), bonsaiDTO.getName(), bonsaiDTO.getSpecies(),bonsaiDTO.getStatus(), null,bonsaiDTO.getAcquisition_age(), null, null, null, null);
    }
}
