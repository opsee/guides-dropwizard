package com.opsee.example;

import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cliff on 6/1/16.
 */
public class ExampleApplication extends Application<ExampleConfiguration> {
    private static Logger log = LoggerFactory.getLogger(ExampleApplication.class);

    public static void main(String[] args) {
        try {
            new ExampleApplication().run(args);
        } catch (Exception ex) {
            log.error("", ex);
        }
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {

    }

    @Override
    public void run(ExampleConfiguration config, Environment env) {
        env.admin().addServlet("admin", AdminServlet.class).addMapping("/admin");
        env.admin().addServlet("metrics", MetricsServlet.class).addMapping("/admin/metrics");
    }
}
