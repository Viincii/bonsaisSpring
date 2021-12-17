package fr.iut.csid.bonsais.bonsai.infrastructure;

import fr.iut.csid.bonsais.bonsai.domain.models.Watering;
import fr.iut.csid.bonsais.common.WateringEntity;

public class WateringEntityMapper {

    public static WateringEntity mapFromWatering(Watering watering){
        WateringEntity wateringEntity = new WateringEntity();
        wateringEntity.setId_watering(watering.getId_watering());
        wateringEntity.setDate(watering.getDate());
        wateringEntity.setBonsai(BonsaiEntityMapper.mapfromBonsai(watering.getBonsai()));
        return wateringEntity;
    }
}
