package Practice;

public class DriverService {
    private final DataBase dataBase;
    private final Driver driver;
    private final PaymentService paymentServise;


    private DriverService(DataBase dataBase, Driver driver, PaymentService paymentService) {
        this.dataBase = dataBase;
        this.driver = driver;
        this.paymentServise = paymentService;
    }

    public static DriverServiceBuilder newBuilder() {
        return new DriverServiceBuilder();
    }

    public static class DriverServiceBuilder {
        private DataBase dataBase;
        private Driver driver;
        private PaymentService paymentService;

        private DriverServiceBuilder() {}

        public DriverServiceBuilder setDataBase(DataBase dataBase) {
            this.dataBase = dataBase;
            return this;
        }

        public DriverServiceBuilder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public DriverServiceBuilder setPaymentService(PaymentService paymentService) {
            this.paymentService = paymentService;
            return this;
        }

        public DriverService build() {
            if (dataBase.isAlive() && driver != null && paymentService.isAlive()) {
                return new DriverService(dataBase, driver, paymentService);
            }
            throw new IllegalStateException("Что то пошло не так");
        }
    }

}
