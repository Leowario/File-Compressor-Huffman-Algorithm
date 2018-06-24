import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static java.lang.String.format;

public class AnotationProcess {

    public static void main(String[] args) {
        Class<Random> randomClassClass = Random.class;
        for (Method method: randomClassClass.getDeclaredMethods()) {
            Documentation methodAnnotation = method.getAnnotation(Documentation.class);
            for (Parameter parameter : method.getParameters()) {
                Documentation parameterAnnotation= parameter.getAnnotation(Documentation.class);
                System.out.println(format("Method %s with documentation %s since %s", method.getName(),
                        (methodAnnotation).text()));
            }
            for (Parameter parameter : method.getParameters()) {
                Annotation parameterAnnotation= parameter.getAnnotation(Documentation.class);
                System.out.println(format("Parameter %s with documentation %s", parameter.getName(),
                        ((Documentation)parameterAnnotation).text()));
            }
        }
    }
}
