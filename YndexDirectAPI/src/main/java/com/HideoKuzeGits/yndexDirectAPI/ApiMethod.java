package com.HideoKuzeGits.yndexDirectAPI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by root on 22.06.14.
 */

@Target(value = ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ApiMethod {
    String methodName() default "";
    boolean withoutNane() default false;
}
