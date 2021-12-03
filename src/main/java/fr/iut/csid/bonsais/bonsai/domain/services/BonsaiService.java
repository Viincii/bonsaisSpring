package fr.iut.csid.bonsais.bonsai.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
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
        Bonsai res = repository.findById(id);
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
        return save(res);

    }

    public void putStatus(String status, UUID id) {
        Bonsai bonsai = findById(id);
        bonsai.setStatus(status);
        save(bonsai);
    }
}
