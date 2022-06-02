package cn.zhoushilan.im.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CallbackBusinessBean {

    String value() default "";

}
