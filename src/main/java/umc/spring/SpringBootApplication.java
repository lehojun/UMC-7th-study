package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import umc.spring.service.StoreService.StoreQueryService;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableJpaAuditing
public class SpringBootApplication {

    public static void main(String[] args) { SpringApplication.run(SpringBootApplication.class, args);}
}


