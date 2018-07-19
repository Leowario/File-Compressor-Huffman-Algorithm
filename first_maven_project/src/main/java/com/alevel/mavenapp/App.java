package com.alevel.mavenapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @Autor Vitalii-Usatyi
 */
public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(server, "/example");

        handler.addServlet(FirstServlet.class, "/");

        server.start();

//        String string = "6,5,7,8,9,1,2,3";
//
//        String arr[] = string.split(",");
//        String sorted[]= sort(arr);
//
//        for (int i = 0; i < sorted.length; i++) {
//
//            System.out.println(sorted[i]);
//        }
    }

    static String[] sort(String[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int first = Integer.parseInt(arr[i]);
                int second = Integer.parseInt(arr[j]);
                if (first > second) {
                    int temp = first;
                    arr[i] = second + "";
                    arr[j] = first + "";
                    i++;
                }
            }
        }
        return arr;
    }
}

