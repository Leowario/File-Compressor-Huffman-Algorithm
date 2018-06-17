package Example;

public class UserBuilder {//не совсем правильно
    private String name;
    private String address;
    private String carNumber;
    private String phoneNumber;
    private boolean gender;
    private String email;

    public UserBuilder setName(String name) {//возвращяет сам себя чтобы потом можно было вызывать через точку
        this.name = name;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public UserBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder setGender(boolean gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User build() {
        if (name == null) {
            throw new IllegalStateException("Name return null");
        }
        if (age <= 0) {
            throw new IllegalStateException("Age  null");
        }
        return new User(name, address, carNumber, phoneNumber, gender, email);
    }
}

