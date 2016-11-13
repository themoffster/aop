package com.themoffster.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.themoffster.aop.annotations.LoggingAspectAfter;
import com.themoffster.aop.annotations.LoggingAspectAfterReturning;
import com.themoffster.aop.annotations.LoggingAspectAfterThrowing;
import com.themoffster.aop.annotations.LoggingAspectAround;
import com.themoffster.aop.annotations.LoggingAspectBefore;

/**
 * A class which shows Spring AOP intercept examples.
 * 
 */
@Aspect
public class Interceptor {

  /** The logger */
  private static final Logger LOGGER = Logger.getLogger(Interceptor.class);

  /**
   * Allows for a method call which has the {@link LoggingAspectBefore} annotation to be
   * intercepted. There is no other limitation on the join point other than it has this annotation.
   * 
   * @param joinPoint the intercepted method call
   */
  @Before("@annotation(com.themoffster.aop.annotations.LoggingAspectBefore)")
  public void before(JoinPoint joinPoint) {
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "()");
  }

  /**
   * Allows for a method call which has the {@link LoggingAspectAfter} annotation to be intercepted.
   * There is no other limitation on the join point other than it has this annotation.
   * 
   * @param joinPoint the intercepted method call
   */
  @After("@annotation(com.themoffster.aop.annotations.LoggingAspectAfter)")
  public void after(JoinPoint joinPoint) {
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "()");
  }

  /**
   * Allows for a method call which has the {@link LoggingAspectAround} annotation to be
   * intercepted. There is no other limitation on the join point other than it has this annotation.<br>
   * This method will be triggered before the join point method is executed as well as after. To do
   * the actual triggering of the join point method, you need to call
   * {@link org.aspectj.lang.ProceedingJoinPoint#proceed proceed}</tt>.
   * 
   * @param joinPoint the intercepted method call
   */
  @Around("@annotation(com.themoffster.aop.annotations.LoggingAspectAround)")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "() entry");
    Object result = joinPoint.proceed();
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "() exit");
    return result;
  }

  /**
   * Allows for a method call which throws an exception to be intercepted after the exception is
   * thrown. For this to happen, the method needs to have the {@link LoggingAspectAfterThrowing}
   * annotation. There is no other limitation on the join point other than it has this annotation.<br>
   * This method will be triggered after the join point method throws an exception.
   * 
   * @param joinPoint the intercepted method call
   * @param ex the exception thrown by the join point method
   */
  @AfterThrowing(pointcut = "@annotation(com.themoffster.aop.annotations.LoggingAspectAfterThrowing)", throwing = "ex")
  public void afterThrowing(JoinPoint joinPoint, Exception ex) {
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "()");
    LOGGER.info("Exception is of type " + ex.getClass().toString());
  }

  /**
   * Allows for a method call which returns normally to be intercepted. For this to happen, the
   * method needs to have the {@link LoggingAspectAfterReturning} annotation. There is no other
   * limitation on the join point other than it has this annotation.<br>
   * This method will be triggered after the join point method returns normally.
   * 
   * @param joinPoint the intercepted method call
   * @param value the value returned from the join point method
   */
  @AfterReturning(pointcut = "@annotation(com.themoffster.aop.annotations.LoggingAspectAfterReturning)", returning = "value")
  public void afterReturning(JoinPoint joinPoint, String value) {
    LOGGER.info("Interceptor >> " + joinPoint.getSignature().getName() + "()");
    LOGGER.info("Value returned value is : " + value);
  }
}
