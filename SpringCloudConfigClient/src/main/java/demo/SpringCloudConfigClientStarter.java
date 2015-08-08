package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;

@SpringBootApplication
@ComponentScan
public class SpringCloudConfigClientStarter {

	  @Value("${cassandra.keyspace}")
	  String keyspace;
	  
	  @Value("${cassandra.contactpoints}")
	  String contactPoint;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientStarter.class, args);
    }
    
    
    @Bean
    @Scope(value = "request",proxyMode = ScopedProxyMode.INTERFACES)
    public CassandraOperations establishDBConnection() {
    	System.out.println("Establishing DB Connection with "+contactPoint +" and Keyspace "+keyspace);
    	return new CassandraTemplate(Cluster.builder().addContactPoint(contactPoint).build().connect(keyspace));
    }
}
