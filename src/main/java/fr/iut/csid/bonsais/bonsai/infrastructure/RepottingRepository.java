package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Repotting;
import fr.iut.csid.bonsais.bonsai.domain.models.RepottingMapper;
import fr.iut.csid.bonsais.common.RepottingDao;
import fr.iut.csid.bonsais.common.RepottingEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RepottingRepository {
    private RepottingDao repottingDao;

    public RepottingRepository(RepottingDao repottingDao) {
        this.repottingDao = repottingDao;
    }

    public List<Repotting> findAll(UUID id_bonsai) {
        List<RepottingEntity> filterdRepottingEntityList = repottingDao.findAllByBonsaiId(id_bonsai);

        List<Repotting> repottingList = new ArrayList<>();

        for (RepottingEntity repottingEntity : filterdRepottingEntityList)
            repottingList.add(RepottingMapper.mapFromEntity(repottingEntity));

        return repottingList;
    }

    public Repotting save(Repotting repotting){
        RepottingEntity repottingEntity = repottingDao.save(RepottingEntityMapper.mapFromRepotting(repotting));
        return RepottingMapper.mapFromEntity(repottingEntity);
    }
}
