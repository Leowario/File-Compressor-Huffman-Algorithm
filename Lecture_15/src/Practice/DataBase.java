package Practice;

public class DataBase {
    private DataBase() {
    }
    public static DataBase instance() {
        return new DataBase();
    }
    public boolean isAlive() {
        return true;
    }


}
