package top.breezes.template.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

/**
 * Nio读写
 *
 * @author yuchengxin
 * @date 2021/6/8 17:39
 */
@Slf4j
public class SimpleReadAndWrite {

    /**
     * 读文件
     * <p>
     * 字符读，转成UTF-8编码
     * </p>
     *
     * @param filePath 文件地址
     */
    public static void simpleRead(String filePath) {
        try (FileChannel channel = new FileInputStream(filePath).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            CharBuffer charBuffer = CharBuffer.allocate(10);
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

            while (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                decoder.decode(byteBuffer, charBuffer, false);
                charBuffer.flip();

                while (charBuffer.hasRemaining()) {
                    // do something
                    log.info(String.valueOf(charBuffer.get()));
                }

                byteBuffer.compact();
                charBuffer.compact();
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 读文件，自定义操作读到字符后的操作
     *
     * @param filePath 文件路径
     * @param consumer 需要对文件内容进行的操作
     */
    public static void readByTemplate(String filePath, Consumer<ByteBuffer> consumer) {
        try (FileChannel channel = new FileInputStream(filePath).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            while (channel.read(byteBuffer) != -1) {
                // 切换到读模式
                byteBuffer.flip();
                // 读到的 byteBuffer 交给方法调用者去处理
                consumer.accept(byteBuffer);
                // 压缩 byteBuffer, 切换到写模式
                byteBuffer.compact();
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 使用读文件的模板方法, 进行UTF-8读
     *
     * @param filePath 文件路径
     */
    public static void readByTemplateToUtf8(String filePath) {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

        readByTemplate(filePath,
                byteBuffer -> {
                    decoder.decode(byteBuffer, charBuffer, false);
                    charBuffer.flip();
                    while (charBuffer.hasRemaining()) {
                        // do something
                        log.info(String.valueOf(charBuffer.get()));
                    }
                    charBuffer.compact();
                });
    }

    /**
     * 模板写
     * <p>
     * 调用读模板方法，写入新文件
     * </p>
     *
     * @param sourcePath 源文件地址
     * @param targetPath 目标文件地址
     */
    public static void writeByReadTemplate(String sourcePath, String targetPath) {
        try (FileChannel write = new RandomAccessFile(targetPath, "rw").getChannel()) {

            readByTemplate(sourcePath,
                    byteBuffer -> {
                        try {
                            write.write(byteBuffer);
                        } catch (IOException e) {
                            String message = String.format("读取文件(%s)异常", sourcePath);
                            log.error(message, e);
                            throw new RuntimeException(message, e);
                        }
                    });

        } catch (Exception e) {
            String message = String.format("读取文件(%s)异常", sourcePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

}
