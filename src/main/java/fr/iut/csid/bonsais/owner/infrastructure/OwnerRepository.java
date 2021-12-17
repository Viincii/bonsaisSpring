package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.domain.models.OwnerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerRepository {

    private OwnerDao ownerDao;

    public OwnerRepository(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }


    public List<Owner> findAll(){
        List<OwnerEntity> ownerEntityList = ownerDao.findAll();
        List<Owner> owners = new ArrayList<>();
        for (OwnerEntity ownerEntity: ownerEntityList){
            owners.add(OwnerMapper.mapFromEntity(ownerEntity));
        }
        return owners;
    }
}
