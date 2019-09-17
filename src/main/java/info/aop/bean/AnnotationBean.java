package info.aop.bean;

import info.aop.AdviceRequired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBean {

    @AdviceRequired
    public void annotatedMethodFirst() {
        System.out.println("annotated method first!");
    }

    @AdviceRequired
    public void annotatedMethodSecond() {
        System.out.println("annotated method second!");
    }

    public void simpleMethod() {
        System.out.println("simple method!");
    }
}
