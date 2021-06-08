package top.breezes.template.colletion;

import java.util.*;

/**
 * 定义标准的常量集合
 *
 * @author yuchengxin
 * @date 2021/6/8 16:04
 */
public class ConstantCollection {

    /**
     * 常量值列表
     */
    public static final List<Integer> CONST_VALUE_LIST = Collections.unmodifiableList(Arrays.asList(1, 2, 3));

    /**
     * 常量值集合
     */
    public static final Set<Integer> CONST_VALUE_SET = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));

    /**
     * 常量值映射
     */
    public static final Map<String, String> CONST_VALUE_MAP;

    static {
        Map<String, String> valueMap = new HashMap<>(4);
        valueMap.put("1", "value1");
        valueMap.put("2", "value2");
        valueMap.put("3", "value3");
        CONST_VALUE_MAP = Collections.unmodifiableMap(valueMap);
    }
}
