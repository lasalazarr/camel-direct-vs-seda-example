package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class DirectEndPointRouter extends RouteBuilder {

    public static final String DIRECT_END = "direct:End";
    public static final String DIRECT_START = "direct:start";

    @Override
    public void configure() throws Exception {
        from(DIRECT_START).routeId("StartRouteId")
                .setBody().simple("Start Message")
                .to(DIRECT_END)
                .log("Message at start route completion = ${body}");


        from(DIRECT_END).routeId("EndRouteId")
                .setBody().simple("End Message")
                .log("message after end-route completion = ${body}");
    }
}
