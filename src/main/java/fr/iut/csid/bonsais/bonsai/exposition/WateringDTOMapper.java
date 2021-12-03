package fr.iut.csid.bonsais.bonsai.exposition;

import fr.iut.csid.bonsais.bonsai.domain.models.Watering;

public class WateringDTOMapper {

    public static WateringDTO mapFromWatering(Watering watering){
        WateringDTO wateringDTO = new WateringDTO();
        wateringDTO.setId_watering(watering.getId_watering());
        wateringDTO.setDate(watering.getDate().toString().replaceAll("T", " "));
        return wateringDTO;
    }
}
