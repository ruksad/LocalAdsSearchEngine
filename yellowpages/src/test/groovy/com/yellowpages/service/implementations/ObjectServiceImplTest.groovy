package com.yellowpages.service.implementations

import com.yellowpages.YellowpagesApplication
import com.yellowpages.model.ObjectEntity
import com.yellowpages.repository.ObjectEntityRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Ruksad siddiqui on 4/3/18
 */
@ContextConfiguration(classes = YellowpagesApplication)
@SpringBootTest
class ObjectServiceImplTest extends Specification {
    def objectEntityRepository=Mock(ObjectEntityRepository )

    def objectServiceImpl=new ObjectServiceImpl(objectEntityRepository)

    def "test this for finObjectsByObjectIdAndAttributeIds"(){
        given:
        def parentId= 60000018
        def list= new ArrayList()
        list.add(50000019)
        list.add(50000020)

        when:
        List<ObjectEntity> entities =objectServiceImpl.finObjectsByObjectIdAndAttributeIds(parentId)

        then:
        !entities.isEmpty()
    }
}
