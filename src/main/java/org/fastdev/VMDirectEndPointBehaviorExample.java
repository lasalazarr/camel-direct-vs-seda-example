package org.fastdev;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.fastdev.routes.VMDirectEndPoint1stRouter;
import org.fastdev.routes.VMDirectEndPoint2ndtRouter;

public class VMDirectEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext firstCamelContext = new DefaultCamelContext();
        firstCamelContext.addRoutes(new VMDirectEndPoint1stRouter());
        firstCamelContext.start();

        CamelContext secondCamelContext = new DefaultCamelContext();
        secondCamelContext.addRoutes(new VMDirectEndPoint2ndtRouter());
        secondCamelContext.start();

        ProducerTemplate producerTemplate = firstCamelContext.createProducerTemplate();
        producerTemplate.sendBody(VMDirectEndPoint1stRouter.VM_DIRECT_START, "Initial Message");
    }
}
