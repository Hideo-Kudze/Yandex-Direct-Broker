package com.HideoKuzeGits.yndexDirectAPI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by root on 12.07.14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.METHOD)
public @interface FinancialMethod {
}
