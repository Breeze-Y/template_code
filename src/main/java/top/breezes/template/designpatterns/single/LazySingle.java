package top.breezes.template.designpatterns.single;

import java.util.Objects;

/**
 * 单例模式-懒汉式双重检验
 *
 * @author yuchengxin
 * @date 2021/6/9 14:46
 */
public class LazySingle {

    private static volatile LazySingle lazySingle = null;

    private LazySingle() {
    }

    public static LazySingle instance() {
        if (Objects.isNull(lazySingle)) {
            synchronized (LazySingle.class) {
                if (Objects.isNull(lazySingle)) {
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }
}
