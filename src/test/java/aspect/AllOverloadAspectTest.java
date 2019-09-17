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
class AllOverloadAspectTest extends SystemOut{

    @Autowired
    BeanOne beanOne;

    @Test
    void test() {
        beanOne.bar();

        assertSystemOut("Method name : bar\n" +
                "Arguments passed []\n" +
                "Before\n" +
                "Hello, bar\n" +
                "After\n");

        beanOne.bar("Hello, bar!");

        assertSystemOut("Method name : bar\n" +
                "Arguments passed [Hello, bar!]\n" +
                "Before\n" +
                "Hello, bar!\n" +
                "After\n");
    }
}
