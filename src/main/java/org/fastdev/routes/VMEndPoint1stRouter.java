package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class VMEndPoint1stRouter extends RouteBuilder {

    public static final String VM_START = "vm:start";
    public static final String VM_END = "vm:end";

    @Override
    public void configure() throws Exception {
        from(VM_START).routeId("StartRouteId")
                .setBody().simple("Start Message")
                .to(VM_END)
                .log("Message at 'start route' completion in first camel context = ${body}");
    }
}
