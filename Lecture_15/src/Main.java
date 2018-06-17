import Example.User;
import Practice.DataBase;
import Practice.Driver;
import Practice.DriverService;
import Practice.PaymentService;

public class Main {


    public static final boolean MEN = true;

    public static void main(String[] args) {
//User.Builder builder =new User.Builder();
//builder
//        .setAddress("Gdeto")
//        .setCarNumber("5125465")
//        .setEmail("lalal@gmail.com")
//        .setGender(MEN)
//        .setName("Vasya")
//        .setPhoneNumber("385784654")
//        .build();
//    }

                DriverService build = DriverService.newBuilder()
                .setDriver(new Driver())
                .setPaymentService(PaymentService.instance())
                .setDataBase(DataBase.instance()).build();
}}
