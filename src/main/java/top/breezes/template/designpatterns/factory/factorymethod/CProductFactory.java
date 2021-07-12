package top.breezes.template.designpatterns.factory.factorymethod;

/**
 * @author yuchengxin
 * @date 2021/7/12 18:17
 */
public class CProductFactory implements ProductFactory {
    /**
     * C工厂
     *
     * @return
     */
    @Override
    public Product createProduct() {
        return new CProduct();
    }
}
