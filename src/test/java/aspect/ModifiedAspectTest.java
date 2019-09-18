package aspect;

import info.aop.aspect.IsModified;
import info.aop.bean.ModifiedBean;
import info.aop.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class ModifiedAspectTest {

    @Autowired
    public ModifiedBean modifiedBean;

    @Test
    public void test() {
        assertTrue("IsModified false", modifiedBean instanceof IsModified);
        assertTrue("Bean not modified", !((IsModified) modifiedBean).isModified());

        modifiedBean.setModifiedVariable("initValue");
        assertTrue("Bean not modified", !((IsModified) modifiedBean).isModified());

        modifiedBean.setModifiedVariable("value");
        assertTrue("Bean modified", ((IsModified) modifiedBean).isModified());
    }
}
