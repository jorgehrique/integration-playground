package br.com.integration_playground.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.com.integration_playground.models.InputDogsResponseBody;

public class InputDogsSplitProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        var payload = exchange.getIn().getBody(InputDogsResponseBody.class);
        exchange.getIn().setBody(payload.facts());    
    }
    
}
