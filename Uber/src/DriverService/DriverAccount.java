package DriverService;

import ServerService.Account;

public class DriverAccount extends Account {
    private Car car;
    private double driverRating;

    public DriverAccount(String firstName, String lastName, String phoneNumber, int age, Sex sex, Car car) {
        super(firstName, lastName, phoneNumber, age, sex);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public double getDriverRating() {
        return driverRating;
    }
}
