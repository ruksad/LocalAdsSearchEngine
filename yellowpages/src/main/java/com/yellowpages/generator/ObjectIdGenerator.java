package com.yellowpages.generator;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ruksad siddiqui on 25/3/18
 */
@Slf4j
public class ObjectIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select MAX(OBJECT_ID) as Id from testypdb.OBJECT");

            if(rs.next())
            {
                Long id=rs.getLong(1)+1;
                log.info("Max id generated is : {}",id );
               return id;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            log.info("error is {}" ,e.getMessage());
        }finally {
            session.shouldAutoClose();
        }


        return null;
    }
}
