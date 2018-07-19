package ServerService;

public abstract class Account {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

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
