package top.breezes.template.designpatterns.single;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * @author yuchengxin
 * @date 2021/6/9 15:06
 */
@Slf4j
public class LazySingleTest {

    public static final int COUNT = 1000;
    private static final CountDownLatch latch1 = new CountDownLatch(COUNT);
    private static final CountDownLatch latch2 = new CountDownLatch(COUNT);
    private static final ConcurrentHashMap<String, String> assertMap = new ConcurrentHashMap<>();

    @Test
    public void should_generate_instance() throws InterruptedException {
        log.info("Thread run start...");

        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    latch1.countDown();
                    latch1.await();
                    LazySingle single = LazySingle.instance();
                    // 存储获取的对象地址值
                    assertMap.put(single.toString(), single.toString());
                    log.info(single.toString());
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    latch2.countDown();
                }
            }).start();
        }

        latch2.await();
        log.info("Thread run end...");
        assertEquals(1, assertMap.size());
    }

}