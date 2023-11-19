package by.pvt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class,args);
    }
}
