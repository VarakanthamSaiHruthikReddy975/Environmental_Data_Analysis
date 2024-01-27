package com.environment.environmentDataAnalysis.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AirQualityLoggingAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(AirQualityLoggingAspect.class);
//
//    @Pointcut("execution(* com.environment.environmentDataAnalysis.Controller.AirQualityController.*(..))")
//    public void AQControllerLayer(){
//        logger.info("The pointcut is executed for the controller methods of air quality class");
//    }
//    @Pointcut("execution(* com.environment.environmentDataAnalysis.Service.AirQualityService.*(..))")
//    public void AQServiceLayer(){
//        logger.info("The pointcut is executed for the service methods of air quality class");
//    }
//    @Before("AQControllerLayer() || AQServiceLayer()")
//    public void logBefore(JoinPoint joinPoint){
//        logger.info("Before execution of method: {}", joinPoint.getSignature().toString());
//    }
//
//    @AfterReturning(pointcut = "AQControllerLayer() || AQServiceLayer()", returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//        logger.info("Method {} completed successfully with result: {}", joinPoint.getSignature(), result);
//    }
//
//    @AfterThrowing(pointcut = "AQControllerLayer() || AQServiceLayer()", throwing = "ex")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
//        logger.error("Method {} threw an exception: {}", joinPoint.getSignature(), ex.getMessage());
//    }
//
//    @After("AQControllerLayer() || AQServiceLayer()")
//    public void logAfter(JoinPoint joinPoint) {
//        logger.info("After execution of method: {}", joinPoint.getSignature());
//    }

}
