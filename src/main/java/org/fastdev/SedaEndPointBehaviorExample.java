package org.fastdev;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.fastdev.routes.SedaEndPointRouter;

public class SedaEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new SedaEndPointRouter());
        camelContext.start();

        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
        producerTemplate.sendBody(SedaEndPointRouter.SEDA_START, "Initial Message");

        Thread.sleep(2000);
    }
}
