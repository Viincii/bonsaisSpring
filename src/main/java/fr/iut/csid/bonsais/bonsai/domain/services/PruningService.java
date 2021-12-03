package fr.iut.csid.bonsais.bonsai.domain.services;


import fr.iut.csid.bonsais.bonsai.domain.models.Pruning;
import fr.iut.csid.bonsais.bonsai.infrastructure.PruningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PruningService {

    private PruningRepository repository;

    public PruningService(PruningRepository repository) {
        this.repository = repository;
    }

    public Pruning save(Pruning watering){
        return repository.save(watering);
    }

    public List<Pruning> findAll(UUID id_bonsai){
        return repository.findAll(id_bonsai);
    }
}
