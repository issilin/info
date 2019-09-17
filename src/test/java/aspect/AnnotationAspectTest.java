package aspect;

import info.aop.bean.AnnotationBean;
import info.aop.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class AnnotationAspectTest extends SystemOut{

    @Autowired
    AnnotationBean annotationBean;

    @Test
    void test() {
        annotationBean.annotatedMethodFirst();

        assertSystemOut("Method name : annotatedMethodFirst\n" +
                        "Before\n" +
                        "annotated method first!\n" +
                        "After\n");

        annotationBean.annotatedMethodSecond();
        assertSystemOut("Method name : annotatedMethodSecond\n" +
                        "Before\n" +
                        "annotated method second!\n" +
                        "After\n");

        annotationBean.simpleMethod();
        assertSystemOut("simple method!\n");
    }
}
