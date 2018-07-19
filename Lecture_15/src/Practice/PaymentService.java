package Practice;

public class PaymentService {

    private PaymentService(){

    }
    public static  PaymentService instance(){//factory metod

    return new PaymentService();
    }
   public boolean isAlive(){
        return true;
   }
}
