package top.breezes.template.io;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.function.Consumer;

/**
 * 缓存字节流读写
 *
 * @author yuchengxin
 * @date 2021/6/9 10:38
 */
@Slf4j
public class SimpleBufferStream {

    /**
     * 带缓冲流字简单节读
     *
     * @param filePath 文件路径
     */
    public static void simpleRead(String filePath) {
        try (BufferedInputStream bufferStream = new BufferedInputStream(new FileInputStream(filePath))) {
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bufferStream.read(bytes)) != -1) {
                // do something
                // 直接输出会乱码
                String info = new String(bytes, 0, len);
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 自定义读
     *
     * @param filePath 文件路径
     * @param consumer 自定义操作
     */
    public static void read(String filePath, Consumer<Entry> consumer) {
        try (BufferedInputStream bufferStream = new BufferedInputStream(new FileInputStream(filePath))) {
            int len = 0;
            byte[] bytes = new byte[1024];
            Entry entry = new Entry();
            while ((len = bufferStream.read(bytes)) != -1) {
                // do something
                // 直接输出会乱码
                entry.setInfo(bytes, len);
                consumer.accept(entry);
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 利用自定义读模板方法, 复制文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void write(String sourcePath, String targetPath) {
        try (BufferedOutputStream bufferStream = new BufferedOutputStream(new FileOutputStream(targetPath))) {
            read(sourcePath,
                    entry -> {
                        try {
                            bufferStream.write(entry.getBytes(), 0, entry.getLen());
                        } catch (IOException e) {
                            String message = String.format("读取文件(%s)异常", sourcePath);
                            log.error(message, e);
                            throw new RuntimeException(message, e);
                        }
                    });
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", sourcePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 封装读取的字节数组和长度
     */
    @Setter
    @Getter
    private static class Entry {
        private byte[] bytes;
        private int len;

        public void setInfo(byte[] bytes, int len) {
            this.bytes = bytes;
            this.len = len;
        }
    }
}
