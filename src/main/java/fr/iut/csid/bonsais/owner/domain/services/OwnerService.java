package fr.iut.csid.bonsais.owner.domain.services;

import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.infrastructure.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAllWithMoreThan(int nbBonsai){
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().filter(owner -> owner.getBonsais().size()>=nbBonsai).collect(Collectors.toList());
    }

}
