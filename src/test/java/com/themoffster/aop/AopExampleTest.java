package com.themoffster.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class AopExampleTest {

  @Autowired
  private AopExample aop;

  @Test
  public void before() {
    aop.before();
  }

  @Test
  public void after() {
    aop.after();
  }

  @Test
  public void around() {
    aop.around();
  }

  @Test(expected = RuntimeException.class)
  public void afterThrowing() {
    aop.afterThrowing();
  }

  @Test
  public void afterReturning() {
    aop.afterReturning();
  }
}
