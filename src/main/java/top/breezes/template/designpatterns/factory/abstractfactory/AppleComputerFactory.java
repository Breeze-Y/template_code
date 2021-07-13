package top.breezes.template.designpatterns.factory.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuchengxin
 * @date 2021/7/13 10:15
 */
@Slf4j
public class AppleComputerFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new AppleCpu();
    }

    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }
}
