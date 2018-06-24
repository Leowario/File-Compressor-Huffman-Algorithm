import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//when
@Target(ElementType.METHOD)//to which type anotatation applied
public @interface Count {
    String documentation() default "";
    String shortName();

}
