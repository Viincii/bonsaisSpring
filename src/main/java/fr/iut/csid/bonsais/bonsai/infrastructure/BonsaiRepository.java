package fr.iut.csid.bonsais.bonsai.infrastructure;


import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.common.BonsaiEntity;
import fr.iut.csid.bonsais.common.BonsaisDao;
import fr.iut.csid.bonsais.user.domain.models.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BonsaiRepository {

    private BonsaisDao bonsaisDao;

    public BonsaiRepository(BonsaisDao dao){
        this.bonsaisDao = dao;
    }


    public Bonsai findById(UUID id){
        Optional<BonsaiEntity> res = bonsaisDao.findById(id);
        return res.map(BonsaiMapper::mapfromEntity).orElse(null);
    }

    public List<Bonsai> findAll() {
        List<BonsaiEntity> bonsaiEntityList = bonsaisDao.findAll();
        List<Bonsai> bonsaisList = new ArrayList<>();
        for (BonsaiEntity bonsaiEntity : bonsaiEntityList){
            bonsaisList.add(BonsaiMapper.mapfromEntity(bonsaiEntity));
        }
        return bonsaisList;
    }

    public Bonsai save(Bonsai bonsai) {
        BonsaiEntity bonsaiEntity = BonsaiEntityMapper.mapfromBonsai(bonsai);
        BonsaiEntity res = bonsaisDao.save(bonsaiEntity);
        return BonsaiMapper.mapfromEntity(res);
    }

    public void deleteById(UUID id) {
        AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))){
            bonsaisDao.deleteById(id);
        }
        else{
         Optional<BonsaiEntity> bonsaiEntity = bonsaisDao.findById(id);
         if (bonsaiEntity.isPresent() && bonsaiEntity.get().getOwner().getId_owner().equals(user.getId())){
             bonsaisDao.deleteById(id);
         }
        }
    }
}
