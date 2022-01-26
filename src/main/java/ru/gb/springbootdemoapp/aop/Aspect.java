package ru.gb.springbootdemoapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
  // execution - методы
  // within - типы
  // annotation - аннотации
  // execution([модификатор_метода]? [тип_возврата] [класс?] [имя_мета]([параметры] [исключения?]))

  long millis;

  @Around("@annotation(ru.gb.springbootdemoapp.aop.Profiling)")
  public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long begin = System.currentTimeMillis();
    Object obj = proceedingJoinPoint.proceed();
    long end = System.currentTimeMillis();
    millis = end - begin;
    System.out.println(millis);

    return obj;
  }

  public long getMillis() {
    return millis;
  }
}
