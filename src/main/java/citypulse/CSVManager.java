package citypulse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVManager {
    public void exportLines(String fileName, List<String> lines) throws IOException {
        Files.write(Path.of(fileName), lines);
    }

    public List<String> importLines(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }
}
