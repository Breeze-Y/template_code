package top.breezes.template.designpatterns.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuchengxin
 * @date 2021/7/13 10:17
 */
@Slf4j
public class HuaweiComputerFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new HuaweiCpu();
    }

    @Override
    public Mouse createMouse() {
        return new HuaweiMouse();
    }

}
