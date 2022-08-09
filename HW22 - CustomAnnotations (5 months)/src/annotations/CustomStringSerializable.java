package annotations;

import java.lang.annotation.*;
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.TYPE })
public @interface CustomStringSerializable {

}
