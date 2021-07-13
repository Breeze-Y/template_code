package top.breezes.template.designpatterns.factory.abstractfactory;

/**
 * 抽象工厂
 *
 * <p>
 * 适合多产品族，产品线构建
 * 例如：每种类型产品都需要一系列对象共同组成，
 * 后期拓展新的组件只需要在抽象工厂加方法，不需要修改原有逻辑
 * 缺点是需要对每个实现抽象工厂的具体工厂类都要添加一遍
 * </p>
 *
 * @author yuchengxin
 * @date 2021/7/12 18:27
 */
public interface AbstractFactory {

    /**
     * 构建抽象CPU
     *
     * @return
     */
    Cpu createCpu();

    /**
     * 构建抽象鼠标
     *
     * @return
     */
    Mouse createMouse();
}
