package fr.iut.csid.bonsais.owner.exposition;

import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.domain.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerControler {

    private OwnerService ownerService;

    public OwnerControler(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAllWithMoreThan(@RequestBody int nbBonsai){
        return ResponseEntity.ok(ownerService.findAllWithMoreThan(nbBonsai).stream().map(owner -> OwnerDTOMapper.mapFromOwner(owner)).collect(Collectors.toList()));
    }
}
