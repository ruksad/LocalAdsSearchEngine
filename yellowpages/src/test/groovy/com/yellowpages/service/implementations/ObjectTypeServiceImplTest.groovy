package com.yellowpages.service.implementations

import com.yellowpages.YellowpagesApplication
import com.yellowpages.model.ObjectTypeEntity
import com.yellowpages.repository.ObjectTypeEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl
import uk.co.jemos.podam.api.PodamUtils

/**
 * Created by Ruksad siddiqui on 6/3/18
 */
@ContextConfiguration(classes = YellowpagesApplication)
@SpringBootTest
class ObjectTypeServiceImplTest extends Specification {

    @Autowired
    ObjectTypeEntityRepository objectTypeEntityRepository
    def podamFactory = new PodamFactoryImpl()



    def "SaveObjectType"() {
        given:"objectTypeEntity"
        PodamUtils.getClassInfo(ObjectTypeEntity)
        def objectTypeEntity=podamFactory.manufacturePojoWithFullData(ObjectTypeEntity)

        when:

        ObjectTypeEntity objectTypeEntity1=objectTypeEntityRepository.save(objectTypeEntity)

        then:
         Objects.nonNull(objectTypeEntity1)
    }
}
