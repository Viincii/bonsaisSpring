package fr.iut.csid.bonsais.bonsai.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Repotting;
import fr.iut.csid.bonsais.bonsai.infrastructure.RepottingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RepottingService {

    private RepottingRepository repository;

    public RepottingService(RepottingRepository repository) {
        this.repository = repository;
    }

    public Repotting save(Repotting repotting){
        return repository.save(repotting);
    }

    public List<Repotting> findAll(UUID id_bonsai){
        return repository.findAll(id_bonsai);
    }
}
