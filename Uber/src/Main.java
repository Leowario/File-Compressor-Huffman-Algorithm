import Driver.Driver;
import Driver.DriverAccount;
import Driver.Car;
import Passenger.Passenger;
import Passenger.PassengerAccount;
import Server.Account;

import static Server.Account.Sex.MEN;

public class Main {
    public static void main(String[] args) {
        PassengerAccount vasyaAccount = new PassengerAccount("Vasya", "Petrov",
                "0554789123", 5, MEN, "2283384488", 41, "ХАЧУ БИСТРО ЕХАТЬ0");
        Passenger passengerVasya = new Passenger(vasyaAccount);

        Car priora = new Car("Priora", "228", 8);
        DriverAccount driverAccount = new DriverAccount("Rafshan", "Chetkiy", "3040228", 29, MEN, priora);
        Driver rafshan = new Driver();


        passengerVasya.orderTaxi("OT suda", "do suda", rafshan,passengerVasya,false);

    }
}
