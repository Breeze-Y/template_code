package top.breezes.template.designpatterns.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuchengxin
 * @date 2021/7/12 17:53
 */
@Slf4j
public class ProductFactoryTest {

    @Test
    public void should_create_product() {
        Product product = ProductFactory.createProduct(AProduct.class);
        assertTrue(product instanceof AProduct);
        product.doSomething();

        product = ProductFactory.createProduct(BProduct.class);
        assertTrue(product instanceof BProduct);
        product.doSomething();
    }
}