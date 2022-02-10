package fr.iut.csid.bonsais.user;

import fr.iut.csid.bonsais.common.UserEntity;
import fr.iut.csid.bonsais.user.domain.models.UserModel;
import fr.iut.csid.bonsais.user.exposition.UserDTO;

public class Mapper {


    public static UserModel mapFromEntity(UserEntity userEntity){
        String auth = null;
        if (!userEntity.getAuthorities().isEmpty()){
            auth = userEntity.getAuthorities().get(0).getAuthority();
        }
        return new UserModel(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), auth);

    }

    public static UserDTO mapFromModel(UserModel userModel) {
        return new UserDTO(userModel.getId(), userModel.getUsername(), userModel.getAuthority());
    }
}
