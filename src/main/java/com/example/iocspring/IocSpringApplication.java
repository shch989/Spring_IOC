package com.example.iocspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class IocSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocSpringApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String url = "www.naver.com/books/it?page=106&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);
    }

}

@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }

}
