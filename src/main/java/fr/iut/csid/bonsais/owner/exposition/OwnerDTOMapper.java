package fr.iut.csid.bonsais.owner.exposition;


import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTOMapper;
import fr.iut.csid.bonsais.owner.domain.models.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerDTOMapper {

    public static OwnerDTO mapFromOwner(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        List<BonsaiDTO> bonsaiDTOList = new ArrayList<>();
        for (Bonsai bonsai: owner.getBonsais()){
            bonsaiDTOList.add(BonsaiDTOMapper.mapFromBonsai(bonsai));
        }
        ownerDTO.setId(owner.getUuid());
        ownerDTO.setName(owner.getName());
        ownerDTO.setBonsaiDTOList(bonsaiDTOList);
        return ownerDTO;
    }
}
