package ServerService;

import java.util.ArrayList;

public class RouteHistory {


       static  ArrayList<Route> routeHistory = new ArrayList<Route>();



    public void getRouteHistory() {
        for (Route r :
                routeHistory) {
            System.out.println(r.toString());
        }
        }


   public void add(Route route){

        routeHistory.add(route);

    }

}
