package PassengerService;

import DriverService.Driver;
import ServerService.Route;
import ServerService.RouteHistory;

public class Passenger {

    private PassengerAccount accaunt;

    public Passenger(PassengerAccount accaunt) {
        this.accaunt = accaunt;
    }

    public void orderTaxi(String startLocation, String finishLocation, Driver driver, Passenger passenger, boolean resultOfRoute){
        Route route = new Route(startLocation,finishLocation,driver,passenger,resultOfRoute);
        RouteHistory routeHistory = new RouteHistory();
        routeHistory.add(route);
    }

public void checkRouteHistory(){
        RouteHistory routeHistory = new RouteHistory();
        routeHistory.getRouteHistory();
}


}
