package fr.iut.csid.bonsais.owner.domain.services;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.services.BonsaiService;
import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.infrastructure.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private BonsaiService bonsaiService;

    public OwnerService(OwnerRepository ownerRepository, BonsaiService bonsaiService) {
        this.ownerRepository = ownerRepository;
        this.bonsaiService = bonsaiService;
    }

    public List<Owner> findAllWithMoreThan(int nbBonsai){
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().filter(owner -> owner.getBonsais().size()>=nbBonsai).collect(Collectors.toList());
    }

    public Optional<Owner> findById(UUID uuid) {
        return ownerRepository.findById(uuid);
    }

    public Owner create(Owner owner){
        return ownerRepository.save(owner);
    }
}
