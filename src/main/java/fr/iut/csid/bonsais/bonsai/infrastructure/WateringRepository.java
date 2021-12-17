package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Watering;
import fr.iut.csid.bonsais.bonsai.domain.models.WateringMapper;
import fr.iut.csid.bonsais.common.WateringDao;
import fr.iut.csid.bonsais.common.WateringEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class WateringRepository {

    private WateringDao wateringDao;

    public WateringRepository(WateringDao wateringDao) {
        this.wateringDao = wateringDao;
    }

    public List<Watering> findAll(UUID id_bonsai) {
        List<WateringEntity> filterdWateringEntityList = wateringDao.findAllByBonsaiId(id_bonsai);

        List<Watering> wateringList = new ArrayList<>();

        for (WateringEntity wateringEntity : filterdWateringEntityList)
            wateringList.add(WateringMapper.mapFromEntity(wateringEntity));

        return wateringList;
    }

    public Watering save(Watering watering){
        WateringEntity wateringRes = wateringDao.save(WateringEntityMapper.mapFromWatering(watering));
        return WateringMapper.mapFromEntity(wateringRes);
    }
}
