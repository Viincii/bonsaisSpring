package fr.iut.csid.bonsais.bonsai.domain.models;

import fr.iut.csid.bonsais.bonsai.exposition.WateringDTO;
import fr.iut.csid.bonsais.bonsai.infrastructure.WateringEntity;

import java.util.Date;

public class WateringMapper {

    public static Watering mapFromEntity(WateringEntity wateringEntity){
        return new Watering(wateringEntity.getId_watering(), wateringEntity.getDate(), BonsaiMapper.mapfromEntity(wateringEntity.getBonsai()));
    }

    public static Watering mapFromDTO(WateringDTO wateringDTO, Bonsai bonsai){
        return new Watering(wateringDTO.getId_watering(), new Date(wateringDTO.getDate()), bonsai);
    }
}
