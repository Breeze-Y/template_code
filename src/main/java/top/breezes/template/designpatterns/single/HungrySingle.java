package top.breezes.template.designpatterns.single;

import sun.jvm.hotspot.opto.HaltNode;

/**
 * 基础饿汉式单例
 *
 * @author yuchengxin
 * @date 2021/7/15 18:00
 */
public class HungrySingle {

    private HungrySingle() {
    }

    private static final HungrySingle INSTANCE = new HungrySingle();

    public static HungrySingle getInstance() {
        return INSTANCE;
    }
}
