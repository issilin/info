package info.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* Аспект на метод класса.
**/
@Component
@Aspect
public class ClassMethodAspect {

    /**
     * Срез на метод с определенной сигнатурой и аргументом
     **/
    @Pointcut("execution(public void info.aop.bean.BeanOne.foo(String)) && args(stringArg)")
    public void classMethod(String stringArg) {
    }

    @Around("classMethod(stringArg)")
    public Object classMethod(ProceedingJoinPoint pjp, String stringArg) throws Throwable {
        System.out.println("Method name : " + pjp.getSignature().getName());

        System.out.println("Argument passed : " + stringArg);
        System.out.println("Before");
        Object retVal = pjp.proceed();
        System.out.println("After");

        return retVal;
    }
}
