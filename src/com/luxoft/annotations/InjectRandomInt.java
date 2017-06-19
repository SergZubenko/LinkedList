package com.luxoft.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Serg on 19.06.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min() default 5;

    int max();
}
