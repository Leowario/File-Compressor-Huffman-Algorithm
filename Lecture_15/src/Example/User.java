package Example;

public class User {

    static int age;
    private final String name;
    private final String address;
    private final String carNumber;
    private final String phoneNumber;
    private final boolean gender;
    private final String email;

    private User(String name, String address, String carNumber, String phoneNumber, boolean gender, String email) {
        this.name = name;
        this.address = address;
        this.carNumber = carNumber;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }
public static Builder newBuilder(){
        return  new Builder();
}

    static class Builder {
        private String name;
        private String address;
        private String carNumber;
        private String phoneNumber;
        private boolean gender;
        private String email;

        public Builder setName(String name) {//возвращяет сам себя чтобы потом можно было вызывать через точку
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCarNumber(String carNumber) {
            this.carNumber = carNumber;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setGender(boolean gender) {
            this.gender = gender;
            return this;
        }

        public Builder setEmail(String email) {
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
}
