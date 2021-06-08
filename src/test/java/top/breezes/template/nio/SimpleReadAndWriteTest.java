package top.breezes.template.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.breezes.template.io.SimpleReadAndWriteByLineTest;

import java.util.Objects;


/**
 * @author yuchengxin
 * @date 2021/6/8 18:05
 */
@Slf4j
public class SimpleReadAndWriteTest {


    private static final String FILE_PATH;

    static {
        FILE_PATH = Objects.requireNonNull(
                SimpleReadAndWriteByLineTest.class.getClassLoader().getResource("test_file.txt"))
                .getPath();
        log.info("SimpleReadTest.FILE_PATH = {}", FILE_PATH);
    }

    @Test
    public void should_read() {
        SimpleReadAndWrite.simpleRead(FILE_PATH);
    }

    @Test
    public void should_read_by_template() {
        SimpleReadAndWrite.readByTemplateToUtf8(FILE_PATH);
    }

    @Test
    public void should_write_by_read_template() {
        SimpleReadAndWrite.writeByReadTemplate(FILE_PATH, "copy_test_file_nio.txt");
    }

}