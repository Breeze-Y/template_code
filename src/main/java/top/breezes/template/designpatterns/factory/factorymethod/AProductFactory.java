package top.breezes.template.designpatterns.factory.factorymethod;


/**
 * @author yuchengxin
 * @date 2021/7/12 18:09
 */
public class AProductFactory implements ProductFactory {
    /**
     * A工厂
     *
     * @return
     */
    @Override
    public Product createProduct() {
        return new AProduct();
    }

}
