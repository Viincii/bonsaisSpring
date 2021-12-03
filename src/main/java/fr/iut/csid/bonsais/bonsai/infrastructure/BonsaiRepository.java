package fr.iut.csid.bonsais.bonsai.infrastructure;


import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
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
        if (res.isPresent()) {
            return BonsaiMapper.mapfromEntity(res.get());
        }
        else
            return null;
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
        bonsaisDao.deleteById(id);
    }
}
