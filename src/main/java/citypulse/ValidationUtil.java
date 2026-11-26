package citypulse;

public class ValidationUtil {
    private ValidationUtil() {}

    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidPriority(int priority) {
        return priority >= 1 && priority <= 5;
    }
}
