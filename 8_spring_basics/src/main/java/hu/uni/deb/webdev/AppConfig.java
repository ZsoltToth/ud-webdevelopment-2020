package hu.uni.deb.webdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String course(){
        return "Web Development";
    }
}
