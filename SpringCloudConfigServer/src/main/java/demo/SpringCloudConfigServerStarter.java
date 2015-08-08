package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerStarter {

	
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerStarter.class, args);
    }
}
