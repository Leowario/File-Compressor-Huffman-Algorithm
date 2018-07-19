public class Test {
    int a = 0;
    boolean success;

//void something (){
//
//    try {
//        throw new ArrayIndexOutOfBoundsException();
//    } catch (ArrayIndexOutOfBoundsException e) {
//        e.printStackTrace();
//    }
//}

    void method() {
        while (a != 5) {

            if (a!=5) {
                try {
                    throw new MyExeption("OOpss!!");
                } catch (MyExeption myExeption) {
                    System.out.println(myExeption.getDescription());
                }
            }
            a++;
        }

        System.out.println("Sucsess");
    }

}
