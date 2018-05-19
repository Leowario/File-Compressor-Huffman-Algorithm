package ServerService;

import DriverService.DriverAccount;
import PassengerService.PassengerAccount;

public class RatingCounter {

    double passegerRatingCount(Route route, PassengerAccount passengerAccount) {

        double passengerRating = passengerAccount.getPassengerRating();

        if (route.getResultOfRoute() == true) {
            if (passengerRating == 10) {
                return 10;
            } else {
                return passengerRating++;
            }
        }
        if (passengerRating == 0) {
            return 0;
        }
        return passengerRating--;

    }

    double driverRatingCount(Route route, DriverAccount driverAccount) {

        double driverRating = driverAccount.getDriverRating();
        if (route.getResultOfRoute() == true) {
            if (driverRating == 10) {
                return 10;
            } else {
                return driverRating++;
            }
        }
        if (driverRating == 0) {
            return 0;
        }
        return driverRating--;
    }

}
