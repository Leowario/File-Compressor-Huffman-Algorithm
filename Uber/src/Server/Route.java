package Server;

import Driver.Driver;
import Passenger.Passenger;

public class Route {
    private String startLocation;
    private String finishLocation;
    private Driver driver;
    private Passenger passenger;
    private boolean resultOfRoute;

    public Route(String startLocation, String finishLocation, Driver driver, Passenger passenger, boolean resultOfRoute) {
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;
        this.driver = driver;
        this.passenger = passenger;
        this.resultOfRoute = resultOfRoute;

//        RouteHistory routeHistory = new RouteHistory();
//        routeHistory.add();
        }

}
