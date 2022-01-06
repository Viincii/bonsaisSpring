package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.common.BonsaiEntity;
import fr.iut.csid.bonsais.common.OwnerEntity;
import fr.iut.csid.bonsais.owner.domain.models.BonsaiOwner;
import fr.iut.csid.bonsais.owner.domain.models.Owner;

import java.util.stream.Collectors;


public class EntityMapper {


    public static BonsaiEntity mapFromBonsaiOwner(BonsaiOwner bonsaiOwner){
        BonsaiEntity entity = new BonsaiEntity();
        entity.setId(bonsaiOwner.getId());
        entity.setAcquisition_age(bonsaiOwner.getAcquisition_age());
        entity.setAcquisition_date(bonsaiOwner.getAcquisition_date());
        entity.setName(bonsaiOwner.getName());
        entity.setSpecies(bonsaiOwner.getSpecies());
        entity.setStatus(bonsaiOwner.getStatus());

        return entity; ///TODO fini?
    }

    public static OwnerEntity mapFromOwner(Owner owner){
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId_owner(owner.getUuid());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsais(owner.getBonsais().stream().map(EntityMapper::mapFromBonsaiOwner).collect(Collectors.toList()));
        return ownerEntity;
    }
}
