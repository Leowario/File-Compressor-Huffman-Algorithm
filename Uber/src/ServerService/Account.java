package ServerService;

public abstract class Account {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private Sex sex;


    public Account(String firstName, String lastName, String phoneNumber, int age, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.sex = sex;
    }

    public enum Sex {
        MEN,
        WOMEN
    }
}
