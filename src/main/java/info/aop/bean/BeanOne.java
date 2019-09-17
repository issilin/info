package info.aop.bean;

import org.springframework.stereotype.Component;

@Component("beanOne")
public class BeanOne {

    public void foo(String arg) {
        System.out.println(arg);
    }

    public String foo() {
        System.out.println("Hello, foo!");
        return "result";
    }

    public void bar() {
        System.out.println("Hello, bar");
    }

    public String bar(String arg) {
        System.out.println(arg);
        return "result";
    }
}
