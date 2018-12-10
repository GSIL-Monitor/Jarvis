package annotation;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/5/15
 */
class AnnoTestController {

    public AnnoTestController() {
        init();
    }

    @LifeCycle(LifeCycle.Life.ONINIT)
    public void init() {

    }

    @LifeCycle(LifeCycle.Life.ONSTART)
    public void start() {

    }

    @LifeCycle(LifeCycle.Life.ONDESTORY)
    public void stop() {

    }

}
