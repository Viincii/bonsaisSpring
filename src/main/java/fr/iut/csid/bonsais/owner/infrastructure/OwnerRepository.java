package fr.iut.csid.bonsais.owner.infrastructure;

import fr.iut.csid.bonsais.common.BonsaisDao;
import fr.iut.csid.bonsais.common.OwnerDao;
import fr.iut.csid.bonsais.common.OwnerEntity;
import fr.iut.csid.bonsais.owner.domain.models.BonsaiOwner;
import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.domain.models.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OwnerRepository {

    private OwnerDao ownerDao;
    private BonsaisDao bonsaisDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaisDao bonsaisDao) {
        this.ownerDao = ownerDao;
        this.bonsaisDao = bonsaisDao;
    }

    public List<Owner> findAll(){
        List<OwnerEntity> ownerEntityList = ownerDao.findAll();
        List<Owner> owners = new ArrayList<>();
        for (OwnerEntity ownerEntity: ownerEntityList){
            owners.add(Mapper.mapOwnerFromEntity(ownerEntity));
        }
        return owners;
    }

    public Optional<Owner> findById(UUID uuid) {
        Optional<OwnerEntity> ownerEntity = ownerDao.findById(uuid);
        return ownerEntity.map(Mapper::mapOwnerFromEntity);
    }

    public Owner save(Owner owner){
        return Mapper.mapOwnerFromEntity(ownerDao.save(EntityMapper.mapFromOwner(owner)));
    }

    public Optional<BonsaiOwner> findBonsaiById(UUID bonsai_id) {
        return bonsaisDao.findById(bonsai_id).map(Mapper::mapfromEntity);
    }

    @Transactional
    public Optional<BonsaiOwner> updateOwner(Owner newOwner, UUID bonsaiId) {
        bonsaisDao.updateOwner(bonsaiId, EntityMapper.mapFromOwner(newOwner));
        return findBonsaiById(bonsaiId);
    }
}
