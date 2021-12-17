package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.common.OwnerEntity;
import fr.iut.csid.bonsais.owner.domain.models.Mapper;
import fr.iut.csid.bonsais.owner.domain.models.Owner;

import java.util.stream.Collectors;


public class EntityMapper {

    public static OwnerEntity mapFromOwner(Owner owner){
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId_owner(owner.getUuid());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsais(owner.getBonsais().stream().map(bonsaiEntity -> Mapper.mapfromEntity(bonsaiEntity)).collect(Collectors.toList()));//TODO
        return ownerEntity;
    }
}
