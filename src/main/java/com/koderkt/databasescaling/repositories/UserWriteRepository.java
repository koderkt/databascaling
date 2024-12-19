package com.koderkt.databasescaling.repositories;

import com.koderkt.databasescaling.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserWriteRepository {
    @Autowired
    @Qualifier("writeMongoTemplate")
    private MongoTemplate writeMongoTemplate;

    public User saveData(User user) {
        System.out.println(user);
        try{
            User res = writeMongoTemplate.save(user);
            System.out.println(res);
            return res;// This uses the primary MongoDB

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}


