package com.koderkt.databasescaling.repositories;

import com.koderkt.databasescaling.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserReadRepository {
    @Autowired
    @Qualifier("writeMongoTemplate")
    private MongoTemplate readMongoTemplate;

    public User getData(String name) {
        return readMongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), User.class);  // This uses the secondary MongoDB
    }
}



