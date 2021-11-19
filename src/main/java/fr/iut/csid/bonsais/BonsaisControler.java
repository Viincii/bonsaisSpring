package fr.iut.csid.bonsais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaisControler {

    private BonsaisDao bonsaisDao;

    public BonsaisControler(BonsaisDao bD){
        this.bonsaisDao=bD;
    }


    @GetMapping
    public List<BonsaiEntity> findBonsais(){
        return bonsaisDao.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> findById(@PathVariable("uuid") UUID id){
        return bonsaisDao.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BonsaiEntity create(@RequestBody BonsaiEntity bonsai){
        return bonsaisDao.save(bonsai);
    }


}
