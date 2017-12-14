package org.fastdev;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.fastdev.routes.VMEndPoint1stRouter;
import org.fastdev.routes.VMEndPoint2ndRouter;

public class VMEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext firstCamelContext = new DefaultCamelContext();
        firstCamelContext.addRoutes(new VMEndPoint1stRouter());
        firstCamelContext.start();

        CamelContext secondCamelContext = new DefaultCamelContext();
        secondCamelContext.addRoutes(new VMEndPoint2ndRouter());
        secondCamelContext.start();

        ProducerTemplate producerTemplate = firstCamelContext.createProducerTemplate();
        producerTemplate.sendBody(VMEndPoint1stRouter.VM_START, "Initial Message");

        Thread.sleep(2000);
    }
}
