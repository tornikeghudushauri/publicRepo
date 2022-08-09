package annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Validator {
    double min() default 1;
    double max() default Integer.MAX_VALUE;
}
