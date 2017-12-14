package org.fastdev.routes;

import org.apache.camel.builder.RouteBuilder;

public class SedaEndPointRouter extends RouteBuilder {
    public static final String SEDA_START = "seda:start";
    public static final String SEDA_END = "seda:End";


    @Override
    public void configure() throws Exception {
        from(SEDA_START).routeId("StartRouteId")
                .setBody().simple("Start Message")
                .to(SEDA_END)
                .log("Message at start route completion = ${body}");


        from(SEDA_END).routeId("EndRouteId")
                .setBody().simple("End Message")
                .log("message after end-router completion = ${body}");
    }
}
