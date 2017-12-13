package org.fastdev;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.fastdev.routes.DirectEndPointRouter;

public class DirectEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new DirectEndPointRouter());
        camelContext.start();

        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
        producerTemplate.sendBody(DirectEndPointRouter.DIRECT_START, "Initial Message");
    }
}
