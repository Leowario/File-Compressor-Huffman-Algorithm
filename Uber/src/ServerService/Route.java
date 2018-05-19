package ServerService;

import DriverService.Driver;
import PassengerService.Passenger;

public class Route {
    private String startLocation;
    private String finishLocation;
    private Driver driver;
    private Passenger passenger;
    private boolean resultOfRoute;

    public String getStartLocation() {
        return startLocation;
    }

    public String getFinishLocation() {
        return finishLocation;
    }

    public Driver getDriver() {
        return driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public boolean getResultOfRoute() {
        return resultOfRoute;
    }

    public Route(String startLocation, String finishLocation, Driver driver, Passenger passenger, boolean resultOfRoute) {
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;
        this.driver = driver;
        this.passenger = passenger;
        this.resultOfRoute = resultOfRoute;

        }

    @Override
    public String toString() {
        return "Route{" +
                "startLocation='" + startLocation + '\'' +
                ", finishLocation='" + finishLocation + '\'' +
                ", driver=" + driver +
                ", passenger=" + passenger +
                ", resultOfRoute=" + resultOfRoute +
                '}';
    }
}
