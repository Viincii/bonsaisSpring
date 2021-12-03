package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.*;
import fr.iut.csid.bonsais.bonsai.domain.services.BonsaiService;
import fr.iut.csid.bonsais.bonsai.domain.services.PruningService;
import fr.iut.csid.bonsais.bonsai.domain.services.RepottingService;
import fr.iut.csid.bonsais.bonsai.domain.services.WateringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/bonsais")
public class BonsaisControler {

    private BonsaiService service;
    private WateringService wateringService;
    private PruningService pruningService;
    private RepottingService repottingService;

    public BonsaisControler(BonsaiService service, WateringService wateringService, PruningService pruningService, RepottingService repottingService) {
        this.service = service;
        this.wateringService = wateringService;
        this.pruningService = pruningService;
        this.repottingService = repottingService;
    }

    @GetMapping
    public ResponseEntity<List<BonsaiDTO>> findBonsais(){
        List<Bonsai> bonsaiList = service.findAll();
        List<BonsaiDTO> bonsaiDTOList = new ArrayList<>();
        for (Bonsai bonsai: bonsaiList){
            bonsaiDTOList.add(BonsaiDTOMapper.mapFromBonsai(bonsai));
        }
        if (!bonsaiDTOList.isEmpty())
            return ResponseEntity.ok(bonsaiDTOList);
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID id){
        try {
            Bonsai bonsai = service.findById(id);
            BonsaiDTO bonsaiDTO = BonsaiDTOMapper.mapFromBonsai(bonsai);
            if(bonsaiDTO.getStatus()==null){
                return ResponseEntity.status(410).build();
            }
            else{
                return ResponseEntity.ok(bonsaiDTO);
            }
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsai){
        Bonsai bonsai1 = BonsaiMapper.mapfromDTO(bonsai);
        Bonsai res = service.save(bonsai1);
        return ResponseEntity.created(URI.create("/bonsais/"+ res.getId())).body(BonsaiDTOMapper.mapFromBonsai(res));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable("uuid") UUID id){
        try{
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> patch(@RequestBody BonsaiDTO bonsaiDTO, @PathVariable("uuid") UUID id){
        try {
            Bonsai body = BonsaiMapper.mapfromDTO(bonsaiDTO);
            Bonsai bonsai1 = service.patch(body, id);
            return ResponseEntity.ok(BonsaiDTOMapper.mapFromBonsai(bonsai1));
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{uuid}/status")
    public ResponseEntity<BonsaiDTO> putStatus(@RequestBody Map<String, String> body, @PathVariable("uuid") UUID id){
        try{
            List<String> acceptedStatus = Arrays.asList("dead", "alive", "unknown");
            if(body.get("status") == null || !acceptedStatus.contains(body.get("status")))
                return ResponseEntity.badRequest().build();
            else{
                service.putStatus(body.get("status"), id);
                return ResponseEntity.noContent().build();
            }
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}/watering")
    public ResponseEntity<List<WateringDTO>> getWaterings(@PathVariable("uuid") UUID id){
        try {
            List<Watering> wateringList = wateringService.findAll(id);
            List<WateringDTO> wateringDTOList = new ArrayList<>();
            for (Watering watering:wateringList)
                wateringDTOList.add(WateringDTOMapper.mapFromWatering(watering));

            return ResponseEntity.ok(wateringDTOList);
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}/pruning")
    public ResponseEntity<List<PruningDTO>> getPrunings(@PathVariable("uuid") UUID id){
        try {
            List<Pruning> pruningList = pruningService.findAll(id);
            List<PruningDTO> pruningDTOList = new ArrayList<>();
            for (Pruning pruning: pruningList)
                pruningDTOList.add(PruningDTOMapper.mapFromPruning(pruning));

            return ResponseEntity.ok(pruningDTOList);
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}/repotting")
    public ResponseEntity<List<RepottingDTO>> getRepottings(@PathVariable("uuid") UUID id){
        try {
            List<Repotting> repottingList = repottingService.findAll(id);
            List<RepottingDTO> repottingDTOList = new ArrayList<>();
            for (Repotting repotting: repottingList)
                repottingDTOList.add(RepottingDTOMapper.mapFromRepotting(repotting));

            return ResponseEntity.ok(repottingDTOList);
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    /*@PostMapping("/{uuid}/watering")
    public ResponseEntity<WateringDTO> createWatering(@RequestBody WateringDTO wateringDTO, @PathVariable("uuid") UUID id){
        Watering watering = WateringMapper.mapFromDTO(wateringDTO, service.findById(id));
        Watering resWatering = wateringService.save(watering);
        return ResponseEntity.created(URI.create("/bonsais/"+ id + "/watering/" + resWatering.getId_pruning())).body(WateringDTOMapper.mapFromPruning(resWatering));
    }*/
}
