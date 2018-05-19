package Server;

import java.util.ArrayList;

public class RouteHistory {
  public ArrayList routeHistory = new ArrayList();

    public ArrayList getRouteHistory() {
        return routeHistory;
    }

    void add(Route route){

        routeHistory.add(route);

    }
}
