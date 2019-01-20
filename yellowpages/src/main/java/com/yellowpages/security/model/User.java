package com.yellowpages.security.model;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.ParametersEntity;
import com.yellowpages.model.enums.categories.UserRegistrationAttributes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 6/4/18
 */
@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String registeredSince;
    private String telephone;
    private String password;
    private String email;
    private String registeredUserStatus;
    private String role;


    public static User from(ObjectEntity objectEntity){
        User user=new User();
        user.setUserId(objectEntity.getObjectId());
        user.setUserName(objectEntity.getName());
        user.setRole(objectEntity.getObjectEntity().getName());
        List<ParametersEntity> parameters = objectEntity.getParameters();

        parameters
        .forEach(parametersEntity -> {
            if(parametersEntity.getAttribute().getAttributeId()== UserRegistrationAttributes.REGISTRATION_SINCE.getDisplayValue().longValue()){
                user.setRegisteredSince(parametersEntity.getValue());
            }else if(parametersEntity.getAttribute().getAttributeId()== UserRegistrationAttributes.TELEPHONE.getDisplayValue().longValue()){
                user.setTelephone(parametersEntity.getValue());
            }else if(parametersEntity.getAttribute().getAttributeId()== UserRegistrationAttributes.EMAIL.getDisplayValue().longValue()){
                user.setEmail(parametersEntity.getValue());
            }else if(parametersEntity.getAttribute().getAttributeId()== UserRegistrationAttributes.PASSWORD.getDisplayValue().longValue()){
                user.setPassword(parametersEntity.getValue());
            }else if(parametersEntity.getAttribute().getAttributeId()== UserRegistrationAttributes.REGISTERED_USER_STATUS.getDisplayValue().longValue()){
                user.setRegisteredUserStatus(parametersEntity.getValue());
            }
        });
        return user;
    }
}
