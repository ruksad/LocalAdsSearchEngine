package com.yellowpages.service.implementations;

import com.yellowpages.exception.YellowPagesApiException;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.AttributeDTO;
import com.yellowpages.model.dto.ListDto;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.model.enums.categories.*;
import com.yellowpages.repository.AttributesEntityRepository;
import com.yellowpages.repository.ListEntityRepository;
import com.yellowpages.repository.ParametersEntityRepository;
import com.yellowpages.security.model.UserRegistrationMandatoryAttr;
import com.yellowpages.service.PostAdRulesService;
import com.yellowpages.utils.CommonUtils;
import com.yellowpages.utils.GenericValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.yellowpages.model.enums.categories.ListsForAttribute.*;

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
@Slf4j
@Service
public class PostAdRuleServiceImpl implements PostAdRulesService {

    private final AttributesEntityRepository attributesEntityRepository;
    private final ParametersEntityRepository parametersEntityRepository;
    private final ListEntityRepository listEntityRepository;

    @Autowired
    public PostAdRuleServiceImpl(AttributesEntityRepository attributesEntityRepository,
                                 ParametersEntityRepository parametersEntityRepository,
                                 ListEntityRepository listEntityRepository){
        this.attributesEntityRepository=attributesEntityRepository;
        this.parametersEntityRepository=parametersEntityRepository;
        this.listEntityRepository=listEntityRepository;
    }

    @Override
    public PostAdDto getUserRegistrationTemplate(){
        PostAdDto postAdDto=new PostAdDto();
        List<Long> attributesIdList = CommonUtils.enumToLongList(UserRegistrationAttributes.class);
        String idsInListToString = CommonUtils.idsInListToString(attributesIdList);

        List<Object[]> attributes=attributesEntityRepository.findAllAttributesInIds(attributesIdList,idsInListToString);
        if(attributes.isEmpty())
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"attributes are not present for ids : "+attributes);

        List<AttributeDTO> attributeDTOS=mapAllAttributesToAttributeDto(attributes);
        if(Objects.isNull(attributeDTOS))throw new RuntimeException("attributes are not present for User");
        postAdDto.setAttributeDTOList(attributeDTOS);
        return postAdDto;

    }

    @Override
    public PostAdDto postAddRuleForVehicle(Long parentId) {
        PostAdDto postAdDto=new PostAdDto();
        postAdDto.setObjectTypeLevel2CategoryId(parentId);

        List<Long> attributeIdList=CommonUtils.enumToLongList(PostAddRuleAttributes.class);
        attributeIdList.addAll(CommonUtils.enumToLongList(VehiclesAttributes.class)) ;

        String idsInListToString = CommonUtils.idsInListToString(attributeIdList);
        List<Object[]> attributes=attributesEntityRepository.findAllAttributesInIds(attributeIdList,idsInListToString);
        if(attributes.isEmpty())
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"attributes are not present for ids : "+attributes);

        List<AttributeDTO> attributeDTOS=mapAllAttributesToAttributeDto(attributes);
        if(Objects.isNull(attributeDTOS))throw new RuntimeException("attributes are not present for vehicles");
        attributeIdList.clear();

        attributeIdList.add(YEAR.getDisplayValue());
        attributeIdList.add(COLOUR.getDisplayValue());
        attributeIdList.add(CONDITION.getDisplayValue());
        attributeIdList.add(FUEL.getDisplayValue());
        attributeIdList.add(TRANSMISSION.getDisplayValue());


        List<Object[]> lists=listEntityRepository.findAllListInIds(attributeIdList,CommonUtils.idsInListToString(attributeIdList));

        if(lists.isEmpty())
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"lists are not present for ids : "+attributeIdList);

        attributeDTOS.addAll(mapAllListToAttributeDto(lists));

        postAdDto.setAttributeDTOList(attributeDTOS);
        return postAdDto;
    }

    @Override
    public PostAdDto postAddRuleForProperties(Long parentId) {
        PostAdDto postAdDto=new PostAdDto();
        postAdDto.setObjectTypeLevel2CategoryId(parentId);

        List<Long> attributeIdList=CommonUtils.enumToLongList(PostAddRuleAttributes.class);
        attributeIdList.addAll(CommonUtils.enumToLongList(PropertiesAttributes.class)) ;

        String idsInListToString = CommonUtils.idsInListToString(attributeIdList);
        List<Object[]> attributes=attributesEntityRepository.findAllAttributesInIds(attributeIdList,idsInListToString);
            if(attributes.isEmpty())
                throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"attributes are not present for ids : "+attributes);

        List<AttributeDTO> attributeDTOS=mapAllAttributesToAttributeDto(attributes);
        if(Objects.isNull(attributeDTOS))throw new RuntimeException("attributes are not present for vehicles");
        attributeIdList.clear();
        attributeIdList.add(BED_ROOMS.getDisplayValue());
        attributeIdList.add(CAR_PARKING.getDisplayValue());
        attributeIdList.add(FURNISHING.getDisplayValue());
        attributeIdList.add(MEALS.getDisplayValue());
        attributeIdList.add(FACING.getDisplayValue());
        List<Object[]> lists=listEntityRepository.findAllListInIds(attributeIdList,CommonUtils.idsInListToString(attributeIdList));

        if(lists.isEmpty())
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"lists are not present for ids : "+attributeIdList);

        attributeDTOS.addAll(mapAllListToAttributeDto(lists));
        postAdDto.setAttributeDTOList(attributeDTOS);
        return postAdDto;
    }

    @Override
    public PostAdDto postAddRuleForCategory( Long parentId) {
        PostAdDto postAdDto=new PostAdDto();
        postAdDto.setObjectTypeLevel2CategoryId(parentId);
        List<Long> attributeList= CommonUtils.enumToLongList(PostAddRuleAttributes.class);

        String idsInListToString = CommonUtils.idsInListToString(attributeList);

        List<Object[]> attributes=attributesEntityRepository.findAllAttributesInIds(attributeList,idsInListToString);
        List<AttributeDTO> attributeDTOS=mapAllAttributesToAttributeDto(attributes);

        if(Objects.isNull(attributeDTOS))
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"attributes are not present for Home and appliances");

        postAdDto.setAttributeDTOList(attributeDTOS);
        return postAdDto;
    }

    @Override
    public ObjectEntity preparePostAdModel(PostAdDto postAdDto) {
        GenericValidator.validateGenericPostAd(postAdDto);
        GenericValidator.validatePostAdForAttributesId(postAdDto,CommonUtils.enumToLongList(MandatoryCommonAttributes.class));
        ObjectEntity objectEntity = ObjectEntity.from(postAdDto);
        return objectEntity;
    }

    @Override
    public ObjectEntity prePareUserRegistration(PostAdDto postAdDto) {
        GenericValidator.validateUserRegistration(postAdDto);
        GenericValidator.validatePostAdForAttributesId(postAdDto,CommonUtils.enumToLongList(UserRegistrationMandatoryAttr.class));
        ObjectEntity objectEntity = ObjectEntity.from(postAdDto);
        return objectEntity;
    }

    private List<AttributeDTO> mapAllAttributesToAttributeDto(List<Object[]> attributes){
      if(Objects.nonNull(attributes)&&!attributes.isEmpty())  {
          List<AttributeDTO> attributeDTOS=new LinkedList<>();
          attributes.stream().forEach(attribute->{
              AttributeDTO attributeDTO=new AttributeDTO();
              attributeDTO.setAttributeId(Objects.nonNull(attribute[0])?((Long) attribute[0]).longValue():null);
              attributeDTO.setAttributeName(String.valueOf(attribute[1]));
              attributeDTO.setAttributeDescription(String.valueOf(attribute[2]));
              attributeDTOS.add(attributeDTO);
          });
          return attributeDTOS;
      }
        throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"attributes are empty");
    }

    private List<AttributeDTO> mapAllListToAttributeDto(List<Object[]> lists){

        if (Objects.nonNull(lists) && !lists.isEmpty()) {
            Map<Object, List<Object[]>> map = lists.stream().collect(Collectors.groupingBy(x -> x[2],Collectors.toCollection(LinkedList::new)));
            List<AttributeDTO> attributeDTOS = new LinkedList<>();
            map.forEach((key, value) -> {
                AttributeDTO attributeDTO = new AttributeDTO();
                attributeDTO.setAttributeId(Objects.nonNull(value.get(0)[2]) ? ((Long) value.get(0)[2]).longValue() : null);
                attributeDTO.setAttributeName(String.valueOf(value.get(0)[3]));
                attributeDTO.setListValues(value.stream().map(x->{
                    ListDto listDto=new ListDto();
                    listDto.setListId(Objects.nonNull(x[0]) ? ((Long) x[0]).longValue() : null);
                    listDto.setListValue(String.valueOf(x[1]));
                    return listDto;
                }).collect(Collectors.toCollection(LinkedList::new)));
                attributeDTO.setAttributeDescription(String.valueOf(value.get(0)[4]));
                attributeDTOS.add(attributeDTO);
            });
            return attributeDTOS;
        }
        throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"lists for attribute is empty");
    }
}
