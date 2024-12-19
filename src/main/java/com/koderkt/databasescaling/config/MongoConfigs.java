package com.koderkt.databasescaling.config;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfigs {

    private String uri = "connection_string";

    @Primary
    @Bean(name = "writeMongoTemplate")
    public MongoTemplate writeMongoTemplate() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();

        MongoClient writeClient = MongoClients.create(settings);

        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(writeClient, "db_Scale"));
    }

    @Bean(name = "readMongoTemplate")
    public MongoTemplate readMongoTemplate() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .readPreference(ReadPreference.secondaryPreferred())
                .build();

        MongoClient readClient = MongoClients.create(settings);
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(readClient, "db_Scale"));
    }
}
