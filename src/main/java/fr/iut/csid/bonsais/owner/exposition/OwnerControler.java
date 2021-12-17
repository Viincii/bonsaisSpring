package fr.iut.csid.bonsais.owner.exposition;

import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsais.owner.domain.models.Owner;
import fr.iut.csid.bonsais.owner.domain.models.OwnerMapper;
import fr.iut.csid.bonsais.owner.domain.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerControler {

    private OwnerService ownerService;

    public OwnerControler(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAllWithMoreThan(@RequestParam int nbBonsai){
        return ResponseEntity.ok(ownerService.findAllWithMoreThan(nbBonsai).stream().map(owner -> OwnerDTOMapper.mapFromOwner(owner)).collect(Collectors.toList()));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(OwnerDTOMapper::mapFromOwner)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{uuid}/bonsais")
    public ResponseEntity<List<BonsaiDTO>> findBonsaisByOwner(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(OwnerDTOMapper::mapFromOwner)
                .map(OwnerDTO::getBonsais)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO owner){
        return ResponseEntity.ok(OwnerDTOMapper.mapFromOwner(ownerService.create(OwnerMapper.mapFromDTO(owner))));
    }
}
