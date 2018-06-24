package com.alevel.mavenapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @Autor Vitalii Usatyi
 */
public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(server, "/example");

        handler.addServlet(FirstServlet.class, "/");

        server.start();
    }
}

