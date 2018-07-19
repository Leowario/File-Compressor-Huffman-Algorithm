package ServerService;

import java.util.ArrayList;
import java.util.List;

public class RouteHistory {

    private final static List<Route> routeHistory = new ArrayList<Route>();

    public void getRouteHistory() {
        for (Route r :
                routeHistory) {
            System.out.println(r.toString());
        }
    }

    public void add(Route route) {

        routeHistory.add(route);
    }
}
