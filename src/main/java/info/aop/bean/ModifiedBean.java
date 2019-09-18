package info.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class ModifiedBean {

    private String modifiedVariable = "initValue";

    public String getModifiedVariable() {
        return modifiedVariable;
    }

    public void setModifiedVariable(String modifiedVariable) {
        this.modifiedVariable = modifiedVariable;
    }
}
