package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntityMapper;
import fr.iut.csid.bonsais.owner.domain.models.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerEntityMapper {

    public static OwnerEntity mapFromOwner(Owner owner){
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(owner.getUuid());
        ownerEntity.setName(owner.getName());

        List<BonsaiEntity> bonsaiEntityList = new ArrayList<>();
        for (Bonsai bonsai: owner.getBonsais()){
            bonsaiEntityList.add(BonsaiEntityMapper.mapfromBonsai(bonsai));
        }
        ownerEntity.setBonsais(bonsaiEntityList);
        return ownerEntity;
    }
}
