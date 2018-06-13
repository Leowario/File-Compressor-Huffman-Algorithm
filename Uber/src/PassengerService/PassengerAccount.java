package PassengerService;

import ServerService.Account;

public class PassengerAccount extends Account {
    private String numberOfCredditCart;
    private double passengerRating;
    private String passengerRequirements;

    public PassengerAccount(String firstName, String lastName,
                            String phoneNumber, int age, Sex sex, String numberOfCredditCart,
                            double passengerRating, String passengerRequirements) {
        super(firstName, lastName, phoneNumber, age, sex);
        this.numberOfCredditCart = numberOfCredditCart;
        this.passengerRating = passengerRating;
        this.passengerRequirements = passengerRequirements;
    }

    public String getNumberOfCredditCart() {
        return numberOfCredditCart;
    }

    public double getPassengerRating() {
        return passengerRating;
    }

    public String getPassengerRequirements() {
        return passengerRequirements;
    }
}
