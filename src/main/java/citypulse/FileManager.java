package citypulse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public void write(String fileName, String content) throws IOException {
        Path path = Path.of(fileName);
        if (path.getParent() != null) Files.createDirectories(path.getParent());
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }

    public String read(String fileName) throws IOException {
        return Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
    }
}
