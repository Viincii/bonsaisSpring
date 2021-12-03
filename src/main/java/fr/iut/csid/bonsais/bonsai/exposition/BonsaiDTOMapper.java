package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Bonsai;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BonsaiDTOMapper {

    public static BonsaiDTO mapFromBonsai(Bonsai bonsai){
        BonsaiDTO dto = new BonsaiDTO();
        dto.setId(bonsai.getId());
        dto.setName(bonsai.getName());
        dto.setSpecies(bonsai.getSpecies());
        dto.setAcquisition_age(bonsai.getAcquisition_age());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date lastWatering = bonsai.getLast_watering();
        if (lastWatering != null)
            dto.setLast_watering(dateFormat.format(lastWatering));
        Date lastPruning = bonsai.getLast_pruning();
        if(lastPruning != null)
            dto.setLast_pruning(dateFormat.format(lastPruning));
        Date lastRepotting = bonsai.getLast_repotting();
        if(lastRepotting != null)
            dto.setLast_repotting(dateFormat.format(lastRepotting));

        dto.setStatus(bonsai.getStatus());
        return dto;
    }
}
