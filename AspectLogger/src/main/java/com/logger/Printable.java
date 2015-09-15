package com.logger;
import java.lang.annotation.*; 

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Printable {

}
