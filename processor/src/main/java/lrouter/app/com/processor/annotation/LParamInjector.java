/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package lrouter.app.com.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface LParamInjector {
    String value();
}
