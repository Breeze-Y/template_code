package top.breezes.template.designpatterns.factory.factorymethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuchengxin
 * @date 2021/7/12 18:18
 */
@Slf4j
public class CProduct implements Product {
    /**
     * 产品抽象方法示例
     */
    @Override
    public void doSomething() {
        log.info("C Product do something...");
    }
}
