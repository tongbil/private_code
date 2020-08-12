package com.google.demoForIdea.threadTool;


import java.lang.annotation.*;

/**
 * 实体类属性注释
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Comment {

	String value() default "";

}