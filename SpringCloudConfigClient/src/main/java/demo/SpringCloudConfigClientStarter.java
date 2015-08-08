package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;

@Configuration
@EnableAutoConfiguration
@ComponentScan(lazyInit=true)
public class SpringCloudConfigClientStarter {

	  @Value("${cassandra.keyspace}")
	  String keyspace;
	  
	  @Value("${cassandra.contactpoints}")
	  String contactPoint;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientStarter.class, args);
    }
    
    
    @Bean
    public CassandraOperations establishDBConnection() {
    	System.out.println("Establishing DB Connection with "+contactPoint +" and Keyspace "+keyspace);
    	return new CassandraTemplate(Cluster.builder().addContactPoint(contactPoint).build().connect(keyspace));
    }
}
