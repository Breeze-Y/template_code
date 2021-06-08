package top.breezes.template.colletion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;


/**
 * @author yuchengxin
 * @date 2021/6/8 16:11
 */
@Slf4j
public class ConstantCollectionTest {

    @Test
    public void should_get_constant_list() {
        List<Integer> list = ConstantCollection.CONST_VALUE_LIST;
        list.forEach(entity -> log.info(String.valueOf(entity)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_unsupported_operation_exception_by_add_list() {
        List<Integer> list = ConstantCollection.CONST_VALUE_LIST;
        list.add(4);
    }

    @Test
    public void should_get_constant_set() {
        Set<Integer> set = ConstantCollection.CONST_VALUE_SET;
        set.forEach(entity -> log.info(String.valueOf(entity)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_unsupported_operation_exception_by_add_set() {
        Set<Integer> set = ConstantCollection.CONST_VALUE_SET;
        set.add(4);
    }

    @Test
    public void should_get_constant_map() {
        Map<String, String> map = ConstantCollection.CONST_VALUE_MAP;
        map.forEach((key, value) -> log.info(key + " : " + value));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_unsupported_operation_exception_by_put_map() {
        Map<String, String> map = ConstantCollection.CONST_VALUE_MAP;
        map.put("4", "value4");
    }

}