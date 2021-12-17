package fr.iut.csid.bonsais.owner.domain.models;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;
import fr.iut.csid.bonsais.owner.infrastructure.OwnerEntity;

import java.util.ArrayList;
import java.util.List;

public class OwnerMapper {

    public static Owner mapFromEntity(OwnerEntity ownerEntity){
        List<Bonsai> bonsais = new ArrayList<>();

        for (BonsaiEntity bonsaiEntity : ownerEntity.getBonsais()){
            bonsais.add(BonsaiMapper.mapfromEntity(bonsaiEntity));
        }

        return new Owner(ownerEntity.getId_owner(), ownerEntity.getName(), bonsais);
    }
}
