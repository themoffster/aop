package com.themoffster.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.themoffster.aop.annotations.LoggingAspectAfter;
import com.themoffster.aop.annotations.LoggingAspectAfterReturning;
import com.themoffster.aop.annotations.LoggingAspectAfterThrowing;
import com.themoffster.aop.annotations.LoggingAspectAround;
import com.themoffster.aop.annotations.LoggingAspectBefore;

@Component
public class AopExample {

  private static final Logger LOGGER = Logger.getLogger(AopExample.class);

  @LoggingAspectBefore
  public void before() {
    LOGGER.info("Inside before()");
  }

  @LoggingAspectAfter
  public void after() {
    LOGGER.info("Inside after()");
  }

  @LoggingAspectAround
  public void around() {
    LOGGER.info("Inside around()");
  }

  @LoggingAspectAfterThrowing
  public void afterThrowing() {
    LOGGER.info("Inside afterThrowing()");
    throw new RuntimeException();
  }

  @LoggingAspectAfterReturning
  public String afterReturning() {
    LOGGER.info("Inside afterReturning()");
    return "finished afterReturning()";
  }
}
