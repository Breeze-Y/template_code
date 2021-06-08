package top.breezes.template.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 逐行读取和写入
 *
 * @author yuchengxin
 * @date 2021/6/8 11:46
 */
@Slf4j
public class SimpleReadAndWriteByLine {

    /**
     * 按行读
     *
     * @param filePath 文件路径
     */
    public static void simpleReadByLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while (Objects.nonNull(line = reader.readLine())) {
                // do something...
                log.info(line);
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 按行读取，并自定义操作每行的内容
     *
     * @param filePath 文件路径
     * @param consumer 需要对每行内容进行的操作
     */
    public static void readByLineByTemplate(String filePath, Consumer<String> consumer) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while (Objects.nonNull(line = reader.readLine())) {
                // do something
                consumer.accept(line);
            }
        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", filePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    /**
     * 使用逐行读取方法，逐行写入新文件中
     *
     * @param sourceFilePath 源文件地址
     * @param targetFilePath 目标文件地址
     * @param append         是否追加写入
     */
    public static void writeByLineUseReadTemplate(String sourceFilePath, String targetFilePath, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(targetFilePath, append), StandardCharsets.UTF_8))) {

            readByLineByTemplate(sourceFilePath,
                    // 逐行写入
                    info -> {
                        try {
                            writer.write(info);
                            writer.newLine();
                        } catch (IOException e) {
                            String message = String.format("读取文件(%s)异常", sourceFilePath);
                            log.error(message, e);
                            throw new RuntimeException(message, e);
                        }
                    });

        } catch (IOException e) {
            String message = String.format("读取文件(%s)异常", sourceFilePath);
            log.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

}
