package fr.iut.csid.bonsais.owner.domain.models;

import fr.iut.csid.bonsais.bonsai.exposition.Status;
import fr.iut.csid.bonsais.common.BonsaiEntity;
import fr.iut.csid.bonsais.owner.exposition.BonsaiOwnerLightDTO;
import fr.iut.csid.bonsais.owner.exposition.OwnerDTO;
import fr.iut.csid.bonsais.common.OwnerEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static Owner mapOwnerFromEntity(OwnerEntity ownerEntity){
        List<BonsaiOwner> bonsais = ownerEntity.getBonsais().stream().map(Mapper::mapfromEntity).collect(Collectors.toList());
        return new Owner(ownerEntity.getId_owner(), ownerEntity.getName(), bonsais);
    }

    public static Owner mapOwnerFromDTO(OwnerDTO owner) {
        List<BonsaiOwner> bonsais = owner.getBonsais().stream().map((Mapper::mapfromDTO)).collect(Collectors.toList());
        return new Owner(owner.getId(), owner.getName(), bonsais);
    }

    public static BonsaiOwner mapfromEntity(BonsaiEntity bonsaiEntity){
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
        return new BonsaiOwner(bonsaiEntity.getId(),bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(), bonsaiEntity.getAcquisition_age(), null, lastWatering, lastPruning, lastRepotting);
    }


    public static BonsaiOwner mapfromDTO(BonsaiOwnerLightDTO bonsaiDTO){
        return new BonsaiOwner(bonsaiDTO.getId(), bonsaiDTO.getName(), bonsaiDTO.getSpecies(), Status.UNKNOWN, null, bonsaiDTO.getAcquisition_age(), null, null, null, null);
    }
}
