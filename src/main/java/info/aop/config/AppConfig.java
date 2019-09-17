package info.aop.config;

import info.aop.aspect.AllOverloadMethodAspect;
import info.aop.aspect.AnnotationAspect;
import info.aop.aspect.ClassMethodAspect;
import info.aop.bean.AnnotationBean;
import info.aop.bean.BeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {

    @Bean(name = "beanOne")
    public BeanOne beanOne() {
        return new BeanOne();
    }

    @Bean
    public ClassMethodAspect myAspect() {
        return new ClassMethodAspect();
    }

    @Bean
    public AllOverloadMethodAspect allOverloadMethodAspect() {
        return new AllOverloadMethodAspect();
    }

    @Bean
    public AnnotationAspect annotationAspect() {
        return new AnnotationAspect();
    }

    @Bean
    public AnnotationBean annotationBean() {
        return new AnnotationBean();
    }
}
