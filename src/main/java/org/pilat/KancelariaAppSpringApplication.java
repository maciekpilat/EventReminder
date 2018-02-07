package org.pilat;

import org.pilat.*;
import javafx.application.Application;
import org.pilat.model.EventCall;
import org.pilat.model.EventTable;
import org.pilat.ocr.UrlRequest;
import org.pilat.service.EventTableService;
import org.pilat.service.EventTableServiceImp;
import org.pilat.service.UserServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class KancelariaAppSpringApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(KancelariaAppSpringApplication.class, args);


    }
}
