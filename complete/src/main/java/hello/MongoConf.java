package hello;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoConf extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "yyy";
    }

    @Override
    protected UserCredentials getUserCredentials() {
        return new UserCredentials("abc", "***");
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}