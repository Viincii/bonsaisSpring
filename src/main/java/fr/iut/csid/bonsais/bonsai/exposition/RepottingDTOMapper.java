package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Repotting;

public class RepottingDTOMapper {

    public static RepottingDTO mapFromRepotting(Repotting repotting){
        RepottingDTO repottingDTO = new RepottingDTO();
        repottingDTO.setId_repotting(repotting.getId_repotting());
        repottingDTO.setDate(repotting.getDate().toString().replaceAll("T", " "));
        return repottingDTO;
    }
}
