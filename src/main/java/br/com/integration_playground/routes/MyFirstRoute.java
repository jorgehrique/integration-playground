package br.com.integration_playground.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// @Component
public class MyFirstRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("...")
            .to("");

    }    

}
