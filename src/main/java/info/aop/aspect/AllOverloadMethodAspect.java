package info.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Аспект на метод класса и перегруженные методы.
 **/
@Component
@Aspect
public class AllOverloadMethodAspect {

    @Pointcut("execution(* info.aop.bean.BeanOne.bar(..))")
    public void allOverloadMethod() {
    }

    @Around("allOverloadMethod()")
    public Object allOverloadMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Method name : " + pjp.getSignature().getName());
        System.out.println("Arguments passed " + Arrays.toString(pjp.getArgs()));

        System.out.println("Before");
        Object retVal = pjp.proceed();
        System.out.println("After");

        return retVal;
    }
}
