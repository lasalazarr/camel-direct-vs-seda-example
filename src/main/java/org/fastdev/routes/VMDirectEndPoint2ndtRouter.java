package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class VMDirectEndPoint2ndtRouter extends RouteBuilder {

    private static final String VM_DIRECT_START = VMDirectEndPoint1stRouter.VM_DIRECT_START;
    private static final String VM_DIRECT_END = VMDirectEndPoint1stRouter.VM_DIRECT_END;

    @Override
    public void configure() throws Exception {
        from(VM_DIRECT_END).routeId("EndRouteId")
                .setBody().simple("End Message")
                .log("Message at 'end route' completion in second camel context = ${body}");
    }
}
