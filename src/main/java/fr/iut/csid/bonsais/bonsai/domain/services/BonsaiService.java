package fr.iut.csid.bonsais.bonsai.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.bonsai.exposition.Status;
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
        bonsai.setStatus(Status.UNKNOWN);
        return repository.save(bonsai);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Bonsai patch(Bonsai bonsai, UUID id) {
        return save(repository.findById(id).update(bonsai));
    }

    public void putStatus(Status status, UUID id) {
        Bonsai bonsai = findById(id);
        bonsai.setStatus(status);
        repository.save(bonsai);
    }

    public void setOwner(UUID id_bonsai, UUID id_owner) {
        Bonsai bonsai = findById(id_bonsai);
        bonsai.setId_owner(id_owner);
        repository.save(bonsai);
    }
}
