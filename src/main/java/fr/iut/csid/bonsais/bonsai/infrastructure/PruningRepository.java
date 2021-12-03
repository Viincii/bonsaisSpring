package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Pruning;
import fr.iut.csid.bonsais.bonsai.domain.models.PruningMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PruningRepository {
    private PruningDao pruningDao;

    public PruningRepository(PruningDao pruningDao) {
        this.pruningDao = pruningDao;
    }

    public List<Pruning> findAll(UUID id_bonsai) {
        List<PruningEntity> filterdPruningEntityList = pruningDao.findAllByBonsaiId(id_bonsai);

        List<Pruning> wateringList = new ArrayList<>();

        for (PruningEntity pruningEntity : filterdPruningEntityList)
            wateringList.add(PruningMapper.mapFromEntity(pruningEntity));

        return wateringList;
    }

    public Pruning save(Pruning pruning){
        PruningEntity pruningEntity = pruningDao.save(PruningEntityMapper.mapFromPruning(pruning));
        return PruningMapper.mapFromEntity(pruningEntity);
    }
}
