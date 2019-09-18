package info.aop.aspect;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Советчик для создания введения.
 **/
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
