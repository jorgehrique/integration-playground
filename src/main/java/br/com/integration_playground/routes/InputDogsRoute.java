package br.com.integration_playground.routes;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import br.com.integration_playground.models.InputDogsResponseBody;
import br.com.integration_playground.processors.InputDogsSplitProcessor;

@Component
public class InputDogsRoute extends RouteBuilder {

    private static String dogsEndpoint = "https://dog-api.kinduff.com/api/facts?number=5";

    @Override
    public void configure() throws Exception {
        
        Endpoint dogsInputEndpoint = endpoint(dogsEndpoint);

        from("timer:foo?period=100000")
            .to(dogsInputEndpoint)
            .unmarshal()
            .json(JsonLibrary.Jackson, InputDogsResponseBody.class)
            // .process(new InputDogsSplitProcessor())
            .log("success: ${body.success}")
            .split(simple("${body.facts}"))
            .log("dog fact: ${body}");
        
    }

}
