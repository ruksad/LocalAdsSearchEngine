package com.yellowpages.service.implementations;

import com.yellowpages.exception.RequestFaultException;
import com.yellowpages.exception.YellowPagesApiException;
import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.ObjectTypeEntity;
import com.yellowpages.model.ParametersEntity;
import com.yellowpages.model.dto.AttributeDTO;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.model.enums.FeaturedCard;
import com.yellowpages.model.enums.categories.UserRegistrationAttributes;
import com.yellowpages.repository.AttributesEntityRepository;
import com.yellowpages.repository.ObjectEntityRepository;
import com.yellowpages.repository.ObjectTypeEntityRepository;
import com.yellowpages.repository.ParametersEntityRepository;
import com.yellowpages.security.exception.AuthenticationException;
import com.yellowpages.service.ObjectService;
import com.yellowpages.service.ObjectTypeService;
import com.yellowpages.utils.CommonUtils;
import com.yellowpages.utils.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.Request;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Ruksad siddiqui on 30/1/18
 */
@Service
@Slf4j
public class ObjectServiceImpl implements ObjectService {

    private final ObjectEntityRepository objectEntityRepository;
    private final PostAdRuleServiceImpl postAdRuleService;
    private final ObjectTypeService objectTypeService;
    private final ObjectTypeEntityRepository objectTypeEntityRepository;
    private final ParametersEntityRepository parametersEntityRepository;
    private final AttributesEntityRepository attributesEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AmazonClient amazonClient;

    @Autowired
    public ObjectServiceImpl(ObjectEntityRepository objectEntityRepository,
                             PostAdRuleServiceImpl postAdRuleService,
                             ObjectTypeService objectTypeService,
                             ObjectTypeEntityRepository objectTypeEntityRepository,
                             ParametersEntityRepository parametersEntityRepository,
                             AttributesEntityRepository attributesEntityRepository,
                             PasswordEncoder passwordEncoder,AmazonClient amazonClient) {
        this.objectEntityRepository = objectEntityRepository;
        this.postAdRuleService = postAdRuleService;
        this.objectTypeService = objectTypeService;
        this.objectTypeEntityRepository = objectTypeEntityRepository;
        this.parametersEntityRepository = parametersEntityRepository;
        this.attributesEntityRepository = attributesEntityRepository;
        this.passwordEncoder=passwordEncoder;
        this.amazonClient=amazonClient;
    }

    @Override
    public List<ObjectEntity> findById(long objectId) {
        if (Objects.nonNull(objectId)) {
            List<ObjectEntity> objectEntity = objectEntityRepository.findByObjectId(objectId);
            if (!objectEntity.isEmpty()) {
                return objectEntity;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object type is not present for the given paramter value");
        }
        return null;
    }

    @Override
    public List<ObjectEntity> findByParameterValue(String parameterValue) {
        if (Objects.nonNull(parameterValue)) {
            List<ObjectEntity> objectEntity = objectEntityRepository.findByParametersValue(parameterValue);
            if (!objectEntity.isEmpty()) {
                return objectEntity;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object type is not present for the given paramter value");
        }
        return null;
    }


    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> getByObjectTypeName(String objectTypeName) {
        if (Objects.nonNull(objectTypeName)) {
            List<ObjectEntity> objectEntities = objectEntityRepository.findByObjectTypeNameIgnoreCase(objectTypeName);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given name: " + String.valueOf(objectTypeName));
        }
        return null;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> findByParameterAndAttribute(String parameter, String attribute) {
        if (Objects.nonNull(attribute) && Objects.nonNull(parameter)) {
            List<ObjectEntity> objectEntities = objectEntityRepository.findByParametersValueIgnoreCaseAndParametersAttributeNameIgnoreCase(parameter, attribute);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given parameter and attribute");
        }
        return null;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> findByObjectIdAndParentId(long id, long parentId) {
        if (Objects.nonNull(id) && Objects.nonNull(parentId)) {
            List<ObjectEntity> objectEntities = objectEntityRepository.findByObjectIdAndObjectEntityObjectId(id, parentId);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object id " + id + "and parent id " + parentId);
        }
        return null;
    }

    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> findByObjectTypeNameAndParentId(String objectTypeName, long parentId) {
        if (Objects.nonNull(objectTypeName) && Objects.nonNull(parentId)) {
            List<ObjectEntity> objectEntities = objectEntityRepository.findByObjectTypeNameIgnoreCaseAndObjectEntityObjectId(objectTypeName, parentId);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object_type name " + objectTypeName + "and parent id " + parentId);
        }
        return null;
    }

    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> findByObjectTypeNamesAndParentId(List<String> objectNames, long parentId) {

        if (!objectNames.isEmpty() && Objects.nonNull(parentId)) {
            List<ObjectEntity> objectEntities = objectEntityRepository.findAllByObjectTypeNameIgnoreCaseInAndObjectEntityObjectId(objectNames, parentId);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object_type names" + objectNames + " and parent id " + parentId);
        }
        return null;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> getByIdAndParentId(List<Long> objectIds, long parentId) {

        if (!objectIds.isEmpty() && Objects.nonNull(parentId)) {

            List<ObjectEntity> objectEntities = objectEntityRepository.findAllByObjectTypeObjectTypeIdInAndObjectEntityObjectId(objectIds, parentId);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object_type ids" + objectIds + " and parent id " + parentId);
        }
        return null;
    }


    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<ObjectEntity> getNameAndDescriptionByObjectTypeIdAndParentId(List<Long> objectTypeIds, long parentId) {
        if (!objectTypeIds.isEmpty() && Objects.nonNull(parentId)) {

            List<ObjectEntity> objectEntities = objectEntityRepository.findAllByObjectTypeObjectTypeIdInAndObjectEntityObjectId(objectTypeIds, parentId);
            if (!objectEntities.isEmpty()) {
                return objectEntities;
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object_type names" + objectTypeIds + " and parent id " + parentId);
        }
        return null;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public FlattenedObjectEntityDto findObjectByObjectIdAndParentId(long objectId, long parentId) {

        if (Objects.nonNull(objectId) && Objects.nonNull(parentId)) {
            ObjectEntity objectEntity = objectEntityRepository.findAllByObjectIdAndObjectEntityObjectId(objectId, parentId);
            if (Objects.nonNull(objectEntity)) {
                return FlattenedObjectEntityDto.from(objectEntity);
            }
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given Object id " + objectId + " and parent id " + parentId);
        }
        return null;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<FlattenedObjectEntityDto> finObjectsByObjectIdAndAttributeIds(Long parentId) {
        if (Objects.nonNull(parentId)) {
            List<Long> parameters = CommonUtils.enumToLongList(FeaturedCard.class);
            List<ObjectEntity> objectEntities = objectEntityRepository.findByObjectEntityObjectIdAndParametersAttributeAttributeIdIn(parentId, parameters);
            List<FlattenedObjectEntityDto> flattenedObjectEntityDtos1 = CommonUtils.getFlattenedObjectEntityDtos(objectEntities);
            if (flattenedObjectEntityDtos1 != null) return flattenedObjectEntityDtos1;
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, "object is not present for the given parent id " + parentId + " and parameters id " + parameters);
        }
        throw new RequestFaultException(ErrorCode.PARENTID_IS_MISSING);
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    @Transactional
    public ObjectEntity postAnAd(PostAdDto postAdDto)  {

        ObjectTypeEntity objectTypeEntity = this.objectTypeService.findById(postAdDto.getObjectTypeId());
        ObjectEntity objectEntity = this.postAdRuleService.preparePostAdModel(postAdDto);
        objectEntity.setObjectType(objectTypeEntity);
        ObjectEntity savedObjectEntity = this.objectEntityRepository.save(objectEntity);
        List<ParametersEntity> save = parametersEntityRepository.save(savedObjectEntity.getParameters());

        return savedObjectEntity;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    @Transactional
    public ObjectEntity registerNewUser(PostAdDto postAdDto){

        List<ObjectEntity> byNameIgnoreCase = this.objectEntityRepository.findByNameIgnoreCase(postAdDto.getName());
        if(Objects.nonNull(byNameIgnoreCase) && !byNameIgnoreCase.isEmpty()){
            throw new RequestFaultException(ErrorCode.USER_WITH_SAME_USER_NAME_EXISTS);
        }

        ObjectTypeEntity objectTypeEntity = this.objectTypeService.findById(postAdDto.getObjectTypeId());
        ObjectEntity objectEntity = this.postAdRuleService.prePareUserRegistration(postAdDto);

        Optional<ParametersEntity> password = objectEntity.getParameters().stream().filter(x -> x.getAttribute().getAttributeId() == UserRegistrationAttributes.PASSWORD.getDisplayValue()).findFirst();

        if(password.isPresent()){
            objectEntity.getParameters().remove(password.get());
            ParametersEntity parametersEntity = password.get();
            String encodedPassword = passwordEncoder.encode(parametersEntity.getValue());
            parametersEntity.setValue(encodedPassword);
            objectEntity.getParameters().add(parametersEntity);
        }

        objectEntity.setObjectType(objectTypeEntity);
        ObjectEntity savedObjectEntity = this.objectEntityRepository.save(objectEntity);
        List<ParametersEntity> save = parametersEntityRepository.save(savedObjectEntity.getParameters());
        return savedObjectEntity;
    }



	@Override
	public List<FlattenedObjectEntityDto> verifyUser(String mobileNumberOrEmail) {
		List<ParametersEntity> params = parametersEntityRepository.findByValue(mobileNumberOrEmail);
		List<ObjectEntity> object_entity = null;
		if (params != null) {
			for (ParametersEntity param : params) {
				Long object_id = param.getObject().getObjectId();
				object_entity = objectEntityRepository.findByObjectId(object_id);
				for (ObjectEntity entity : object_entity) {
					if (entity.getObjectType().getObjectTypeId() == 90000132) {
						return CommonUtils.getFlattenedObjectEntityDtos(object_entity);
					}
				}
			}
			throw new RequestFaultException(ErrorCode.USER_NOT_EXIST);
		} else {
			throw new RequestFaultException(ErrorCode.USER_NOT_EXIST);
		}
	}
}
