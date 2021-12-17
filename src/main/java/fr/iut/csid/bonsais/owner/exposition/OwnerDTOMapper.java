package fr.iut.csid.bonsais.owner.exposition;


import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTOMapper;
import fr.iut.csid.bonsais.owner.domain.models.Owner;

import java.util.stream.Collectors;

public class OwnerDTOMapper {

    public static OwnerDTO mapFromOwner(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getUuid());
        ownerDTO.setName(owner.getName());
        ownerDTO.setBonsais(owner.getBonsais().stream().map(bonsai -> BonsaiDTOMapper.mapFromBonsai(bonsai)).collect(Collectors.toList()));
        return ownerDTO;
    }
}
