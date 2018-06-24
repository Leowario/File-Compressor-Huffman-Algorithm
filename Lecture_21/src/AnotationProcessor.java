import java.lang.reflect.Method;

public class AnotationProcessor {
    public static void main(String[] args) {



        Class clazz = Driver.class;
         for (Method method : clazz.getDeclaredMethods()) {
            Count annotation = method.getAnnotation(Count.class);//
            if(annotation!=null){
                System.out.println(annotation.shortName());//sout discription of shortName from anotation in Driver
            }
        }

    }

}
