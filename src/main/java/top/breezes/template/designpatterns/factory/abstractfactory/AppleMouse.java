package top.breezes.template.designpatterns.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuchengxin
 * @date 2021/7/13 10:23
 */
@Slf4j
public class AppleMouse implements Mouse {

    @Override
    public void doSomething() {
        log.info("apple mouse");
    }
}
