package Driver;

import Server.Account;

public class DriverAccount extends Account {
    private Car car;

    public DriverAccount(String firstName, String lastName, String phoneNumber, int age, Sex sex, Car car) {
        super(firstName, lastName, phoneNumber, age, sex);
        this.car = car;
    }
}
