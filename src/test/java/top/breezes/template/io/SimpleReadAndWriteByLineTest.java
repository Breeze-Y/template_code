package top.breezes.template.io;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @author yuchengxin
 * @date 2021/6/8 12:20
 */
@Slf4j
public class SimpleReadAndWriteByLineTest {

    private static final String FILE_PATH;

    static {
        FILE_PATH = Objects.requireNonNull(
                SimpleReadAndWriteByLineTest.class.getClassLoader().getResource("test_file.txt"))
                .getPath();
        log.info("SimpleReadTest.FILE_PATH = {}", FILE_PATH);
    }

    @Test
    public void should_read_by_line() {
        SimpleReadAndWriteByLine.simpleReadByLine(FILE_PATH);
    }

    @Test
    public void should_read_by_line_by_template() {
        SimpleReadAndWriteByLine.readByLineByTemplate(FILE_PATH, log::info);
    }

    @Test
    public void should_write_by_line_use_read_template() {
        SimpleReadAndWriteByLine.writeByLineUseReadTemplate(FILE_PATH,
                "copy_test_file.txt", false);
    }
}