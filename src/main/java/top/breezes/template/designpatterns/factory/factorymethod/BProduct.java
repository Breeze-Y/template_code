package top.breezes.template.designpatterns.factory.factorymethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuchengxin
 * @date 2021/7/12 17:41
 */
@Slf4j
public class BProduct implements Product {
    /**
     * B产品抽象方法示例
     */
    @Override
    public void doSomething() {
        log.info("B Product do something...");
    }
}
