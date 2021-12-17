package fr.iut.csid.bonsais.owner.exposition;

import fr.iut.csid.bonsais.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsais.owner.domain.models.Mapper;
import fr.iut.csid.bonsais.owner.domain.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnersController {

    private OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAllWithMoreThan(@RequestParam int nbBonsai){
        return ResponseEntity.ok(ownerService.findAllWithMoreThan(nbBonsai).stream().map(owner -> DTOMapper.mapDTOFromOwner(owner)).collect(Collectors.toList()));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(DTOMapper::mapDTOFromOwner)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{uuid}/bonsais")
    public ResponseEntity<List<BonsaiOwnerLightDTO>> findBonsaisByOwner(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(DTOMapper::mapDTOFromOwner)
                .map(OwnerDTO::getBonsais)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO owner){
        OwnerDTO ownerDTO = DTOMapper.mapDTOFromOwner(ownerService.create(Mapper.mapOwnerFromDTO(owner)));
        return ResponseEntity.created(URI.create("/owners/"+ ownerDTO.getId())).body(ownerDTO);
    }

    @PostMapping("/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> transfertBonsai(@PathVariable("owner_id") UUID owner_id, @PathVariable("bonsai_id") UUID bonsai_id, @RequestBody UUID new_owner_id){
        //TODO
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{owner_id}/bonsai")
    public ResponseEntity<BonsaiDTO> addBonsai(@PathVariable("owner_id") UUID owner_id, @RequestBody UUID bonsai_id){
        //TODO
        return ResponseEntity.notFound().build();
    }
}
