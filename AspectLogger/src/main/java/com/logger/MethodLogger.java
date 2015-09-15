package com.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MethodLogger {
	 final Logger logger = LoggerFactory.getLogger("logger");
	 
	 @Around("execution(* *(..)) && @annotation(com.logger.Loggerable)")
	 public void around(ProceedingJoinPoint point) throws Throwable {
		    long start = System.currentTimeMillis();
		    Object result = point.proceed();
		    String s = String.format("#%s(%s): %s in %s",
				      MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
				      point.getArgs(),
				      result,
				      System.currentTimeMillis() - start);
		    logger.info(s);
		    System.out.println("test aspect");
		    System.out.println( MethodSignature.class.cast(point.getSignature()).getMethod().getName());
	 }
	 
	 @Before("execution(* *(..)) && @annotation(com.logger.Printable)")
	 public void BeforePrintable(){
		    System.out.println("*****************************test aspect");
		   
	 }
}