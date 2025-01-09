package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CounterAspect {

    private int counts=0;

    @Pointcut("@annotation(Counter)")
    public void executeCounter(){

    }
    @AfterReturning(pointcut = "executeCounter()", returning = "returnValue")
    public void counterMethod(JoinPoint joinPoint, Object returnValue){
        System.out.println(counts);
        counts++;
    }
}
