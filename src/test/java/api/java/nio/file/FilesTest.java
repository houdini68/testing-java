package api.java.nio.file;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class FilesTest {

    @Test
    public void whenCreateTempFile_thenTempFileIsCreated() {
        try {
            Path tempFile = Files.createTempFile(null, ".myapp");
            // /tmp/1063942235502049642.myapp
            assertThat(tempFile).exists();
        } catch (IOException e) {
            fail("It was not possible to create the temp file!");
        }
    }
}
