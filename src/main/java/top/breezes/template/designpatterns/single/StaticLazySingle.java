package top.breezes.template.designpatterns.single;

/**
 * 懒汉模式-静态内部类方式
 *
 * @author yuchengxin
 * @date 2021/7/15 18:11
 */
public class StaticLazySingle {

    private StaticLazySingle() {
    }

    /**
     * 静态内部类
     * <p>
     *     StaticLazySingle类加载时候Handler不会加载，getInstance()时才会加载
     *     线程安全由JVM保证
     * </p>
     */
    private static class Handler {
        private static final StaticLazySingle INSTANCE = new StaticLazySingle();
    }

    public static StaticLazySingle getInstance() {
        return Handler.INSTANCE;
    }
}
