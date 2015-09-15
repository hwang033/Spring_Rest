1. in pom.xml
		<!-- Aspect -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>1.7.3</version>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.8.6</version>
		</dependency>
2. in application-config.xml
   xmlns:aop="http://www.springframework.org/schema/aop"
   xsi:schemaLocation="...
                           http://www.springframework.org/schema/aop 
                           http://www.springframework.org/schema/aop/spring-aop.xsd">
  	
  	<aop:aspectj-autoproxy/>
		<bean id="myAspect" class="com.logger.MethodLogger">
	  </bean>
3. define apsect using @Aspect. Look at MethodLogger file 
4. define a annotation. With
      @Retention(RetentionPolicy.RUNTIME)
      @Target(ElementType.METHOD)
  look at Loggerable.java
5. Use the defined annotation in your program by @Loggerable in LoggerController.java 



