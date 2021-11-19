package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;
import fr.iut.csid.bonsais.bonsai.domain.models.BonsaiMapper;
import fr.iut.csid.bonsais.bonsai.domain.services.BonsaiService;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaiEntity;
import fr.iut.csid.bonsais.bonsai.infrastructure.BonsaisDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaisControler {

    private BonsaiService service;

    public BonsaisControler(BonsaiService serv){
        this.service=serv;
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
            return ResponseEntity.ok(bonsaiDTO);
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
            return ResponseEntity.ok().build();
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

}
