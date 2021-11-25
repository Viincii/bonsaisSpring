package fr.iut.csid.bonsais.bonsai.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BonsaiService {

    private BonsaiRepository repository;

    public BonsaiService(BonsaiRepository repo){
        this.repository=repo;
    }

    public Bonsai findById(UUID id) {
        return repository.findById(id);
    }

    public List<Bonsai> findAll() {
        return repository.findAll();
    }

    public Bonsai save(Bonsai bonsai) {
        return repository.save(bonsai);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Bonsai patch(Bonsai bonsai, UUID id) {
        return repository.patch(bonsai, id);
    }
}