package fr.iut.csid.bonsais.bonsai.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Watering;
import fr.iut.csid.bonsais.bonsai.infrastructure.WateringRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WateringService {

    private WateringRepository repository;

    public WateringService(WateringRepository repository) {
        this.repository = repository;
    }

    public Watering save(Watering watering){
        return repository.save(watering);
    }

    public List<Watering> findAll(UUID id_bonsai){
        return repository.findAll(id_bonsai);
    }
}
