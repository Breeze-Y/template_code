package top.breezes.template.designpatterns.factory.factorymethod;


/**
 * @author yuchengxin
 * @date 2021/7/12 18:10
 */
public class BProductFactory implements ProductFactory {
    /**
     * B工厂
     *
     * @return
     */
    @Override
    public Product createProduct() {
        return new BProduct();
    }
}
