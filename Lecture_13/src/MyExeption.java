public class MyExeption extends Exception {

    private String s;

    public MyExeption(String message) {
        super(message);
        s=message;
    }

    public String getDescription() {
        return s;
    }
}
