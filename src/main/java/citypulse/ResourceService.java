package citypulse;

// Demonstrates a common service class for shared resource validation.
public class ResourceService {
    public boolean isValidLocation(String location) {
        return ValidationUtil.isNotBlank(location);
    }
}
