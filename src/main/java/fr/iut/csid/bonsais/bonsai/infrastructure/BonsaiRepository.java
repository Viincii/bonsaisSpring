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

    public Bonsai patch(Bonsai bonsai, UUID id) {
        BonsaiEntity res = bonsaisDao.getById(id);
        if (bonsai.getName() != null){
            res.setName(bonsai.getName());
        }
        if (bonsai.getSpecies()!= null){
            res.setSpecies(bonsai.getSpecies());
        }
        if (bonsai.getAcquisition_date()!= null){
            res.setAcquisition_date(bonsai.getAcquisition_date());
        }
        if (bonsai.getAcquisition_age()!= 0){
            res.setAcquisition_age(bonsai.getAcquisition_age());
        }
        bonsaisDao.deleteById(id);
        return save(BonsaiMapper.mapfromEntity(res));

    }
}
