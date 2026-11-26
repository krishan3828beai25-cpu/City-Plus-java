package citypulse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private DateTimeUtil() {}

    public static String now() {
        return LocalDateTime.now().format(FORMAT);
    }
}
