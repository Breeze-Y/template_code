package top.breezes.template.designpatterns.factory.factorymethod;


/**
 * 工厂方法模式
 * <p>
 * 优点：拓展方便，无需修改之前代码。新增新产品时，只需要实现工厂接口，
 * 纵向拓展同类型（都可实现Product空接口）产品类型方便
 * 缺点：新增新的不同类型（不能实现Product的产品）产品时需要新建工厂接口。
 * </p>
 *
 * @author yuchengxin
 * @date 2021/7/12 18:08
 */
public interface ProductFactory {

    /**
     * 工厂抽象方法
     *
     * @return
     */
    Product createProduct();
}
