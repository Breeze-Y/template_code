package top.breezes.template.designpatterns.factory.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuchengxin
 * @date 2021/7/13 10:34
 */
public class AbstractFactoryTest {

    @Test
    public void should_create_cpu() {
        AbstractFactory factory = new AppleComputerFactory();
        Cpu cpu = factory.createCpu();
        assertTrue(cpu instanceof AppleCpu);
        cpu.doSomething();


        factory = new HuaweiComputerFactory();
        cpu = factory.createCpu();
        assertTrue(cpu instanceof HuaweiCpu);
        cpu.doSomething();

    }

    @Test
    public void should_create_mouse() {
        AbstractFactory factory = new AppleComputerFactory();
        Mouse mouse = factory.createMouse();
        assertTrue(mouse instanceof AppleMouse);
        mouse.doSomething();

        factory = new HuaweiComputerFactory();
        mouse = factory.createMouse();
        assertTrue(mouse instanceof HuaweiMouse);
        mouse.doSomething();
    }
}