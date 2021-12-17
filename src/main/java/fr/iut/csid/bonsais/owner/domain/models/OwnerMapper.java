package fr.iut.csid.bonsais.owner.domain.models;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.owner.exposition.OwnerDTO;
import fr.iut.csid.bonsais.owner.infrastructure.OwnerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerMapper {

    public static Owner mapFromEntity(OwnerEntity ownerEntity){
        List<Bonsai> bonsais = ownerEntity.getBonsais().stream().map(bonsaiEntity -> BonsaiMapper.mapfromEntity(bonsaiEntity)).collect(Collectors.toList());
        return new Owner(ownerEntity.getId_owner(), ownerEntity.getName(), bonsais);
    }

    public static Owner mapFromDTO(OwnerDTO owner) {
        List<Bonsai> bonsais = owner.getBonsais().stream().map((bonsaiDTO -> BonsaiMapper.mapfromDTO(bonsaiDTO))).collect(Collectors.toList());
        return new Owner(owner.getId(), owner.getName(), bonsais);
    }
}
