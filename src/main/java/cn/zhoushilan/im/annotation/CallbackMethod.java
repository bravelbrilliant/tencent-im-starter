package cn.zhoushilan.im.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CallbackMethod {

    String callbackCmd() default "";

    Class<?> paramClass();
}
