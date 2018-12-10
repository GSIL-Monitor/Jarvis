package annotation;

import java.lang.annotation.*;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/5/15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface LifeCycle {

    enum Life {ONINIT, ONSTART, ONDESTORY, NONE}

    Life value() default Life.NONE;

}
