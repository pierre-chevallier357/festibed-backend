
package com.example;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class RestServer {

    @RequestMapping(
        value = "/hello", 
        method = RequestMethod.GET,
        produces = "application/json")
    @ResponseBody

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestServer.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "4200"));
        app.run(args);
    }

}
