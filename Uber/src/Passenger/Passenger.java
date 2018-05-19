package Passenger;

import Driver.Driver;
import Server.Route;

public class Passenger {

    private PassengerAccount accaunt;

    public Passenger(PassengerAccount accaunt) {
        this.accaunt = accaunt;
    }

    public void orderTaxi(String startLocation, String finishLocation, Driver driver, Passenger passenger, boolean resultOfRoute){
        Route route = new Route(startLocation,finishLocation,driver,passenger,resultOfRoute);
    }


}
