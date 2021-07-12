package top.breezes.template.designpatterns.factory.simplefactory;

import org.apache.commons.lang3.StringUtils;

/**
 * 简单工厂(静态工厂)
 * 优点：实现简单
 * 缺点：新增新的产品类型需要修改工厂方法
 *
 * @author yuchengxin
 * @date 2021/7/12 17:30
 */
public class ProductFactory {

    public static Product createProduct(Class<? extends Product> clazz) {
        String clazzName = clazz.getName();
        if (StringUtils.equals(clazzName, AProduct.class.getName())) {
            return new AProduct();
        }
        if (StringUtils.equals(clazzName, BProduct.class.getName())) {
            return new BProduct();
        }
        return null;
    }
}
