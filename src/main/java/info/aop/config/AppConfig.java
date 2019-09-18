package info.aop.config;

import com.sun.org.apache.xpath.internal.operations.Mod;
import info.aop.aspect.*;
import info.aop.bean.AnnotationBean;
import info.aop.bean.BeanOne;
import info.aop.bean.ModifiedBean;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
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

    @Bean
    public IsModifiedMixin modifiedAspect() {
        return new IsModifiedMixin();
    }

    /**
     * Создается проксли для использования бина с введением.
     **/
    @Bean
    public ModifiedBean modifiedBean() {
        ModifiedBean result = new ModifiedBean();

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(result);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        return (ModifiedBean) pf.getProxy();
    }
}
