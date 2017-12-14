package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class VMEndPoint2ndRouter extends RouteBuilder {

    private static final String VM_START = VMEndPoint1stRouter.VM_START;
    private static final String VM_END = VMEndPoint1stRouter.VM_END;

    @Override
    public void configure() throws Exception {
        from(VM_END).routeId("EndRouteId")
                .setBody().simple("End Message")
                .log("Message at 'end route' completion in second camel context = ${body}");
    }
}
