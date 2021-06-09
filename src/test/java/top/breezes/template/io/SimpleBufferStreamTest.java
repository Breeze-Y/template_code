package top.breezes.template.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * @author yuchengxin
 * @date 2021/6/9 10:56
 */
@Slf4j
public class SimpleBufferStreamTest {

    private static final String FILE_PATH;

    static {
        FILE_PATH = Objects.requireNonNull(
                SimpleReadAndWriteByLineTest.class.getClassLoader().getResource("test_file.txt"))
                .getPath();
        log.info("SimpleReadTest.FILE_PATH = {}", FILE_PATH);
    }

    @Test
    public void should_simple_read() {
        SimpleBufferStream.simpleRead(FILE_PATH);
    }

    @Test
    public void should_simple_write() {
        SimpleBufferStream.write(FILE_PATH, "copy_test_file_buffer_stream.txt");
    }
}