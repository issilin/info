package info.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Аспект на метод класса по аннотации.
 **/
@Component
@Aspect
public class AnnotationAspect {

    @Pointcut("@annotation(info.AdviceRequired)")
    public void annotationMethod() {
    }

    @Around("annotationMethod()")
    public Object annotationMethodAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Method name : " + pjp.getSignature().getName());

        System.out.println("Before");
        Object retVal = pjp.proceed();
        System.out.println("After");

        return retVal;
    }
}
