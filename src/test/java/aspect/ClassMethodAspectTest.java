package aspect;

import info.aop.config.AppConfig;
import info.aop.bean.BeanOne;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class ClassMethodAspectTest extends SystemOut {

    @Autowired
    BeanOne beanOne;

    @Test
    void test() {
        beanOne.foo();
        assertSystemOut("Hello, foo!\n");

        beanOne.foo("Hello, foo!");
        assertSystemOut("Method name : foo\n" +
                        "Argument passed : Hello, foo!\n" +
                        "Before\n" +
                        "Hello, foo!\n" +
                        "After\n");
    }
}
