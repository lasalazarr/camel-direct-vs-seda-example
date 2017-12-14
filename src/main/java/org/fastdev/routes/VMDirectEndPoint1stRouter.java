package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class VMDirectEndPoint1stRouter extends RouteBuilder{

    public static final String VM_DIRECT_START = "direct-vm:start";
    public static final String VM_DIRECT_END = "direct-vm:end";

    @Override
    public void configure() throws Exception {
        from(VM_DIRECT_START).routeId("StartRouteId")
                .setBody().simple("Start Message")
                .to(VM_DIRECT_END)
                .log("Message at 'start route' completion in first camel context  = ${body}");
    }
}
