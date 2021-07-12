package top.breezes.template.designpatterns.factory.factorymethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuchengxin
 * @date 2021/7/12 18:13
 */
public class ProductFactoryTest {

    @Test
    public void should_create_product() {
        ProductFactory factory = new AProductFactory();
        Product product = factory.createProduct();
        assertTrue(product instanceof AProduct);
        product.doSomething();

        factory = new BProductFactory();
        product = factory.createProduct();
        assertTrue(product instanceof BProduct);
        product.doSomething();

        factory = new CProductFactory();
        product = factory.createProduct();
        assertTrue(product instanceof CProduct);
        product.doSomething();
    }

}