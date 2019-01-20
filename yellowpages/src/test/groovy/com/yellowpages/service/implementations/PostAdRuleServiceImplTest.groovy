package com.yellowpages.service.implementations

import com.yellowpages.YellowpagesApplication
import com.yellowpages.model.ObjectTypeEntity
import com.yellowpages.model.dto.PostAdDto
import com.yellowpages.repository.AttributesEntityRepository
import com.yellowpages.repository.ParametersEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl
import uk.co.jemos.podam.api.PodamUtils

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
@ContextConfiguration(classes = YellowpagesApplication)
@SpringBootTest
class PostAdRuleServiceImplTest extends Specification {


    @Autowired
    AttributesEntityRepository attributesEntityRepository
    @Autowired
    ParametersEntityRepository parametersEntityRepository
    def podamFactory = new PodamFactoryImpl()
    def postAdRuleServiceImpl=new PostAdRuleServiceImpl(attributesEntityRepository,parametersEntityRepository)

    def "postAddRuleForVehicle sdsd"() {
        given:"objectTypeEntity"

        when:

        PostAdDto postAdDto=postAdRuleServiceImpl.postAddRuleForVehicle(60000019l,90000109l)

        then:
        Objects.nonNull(postAdDto)
    }


}
