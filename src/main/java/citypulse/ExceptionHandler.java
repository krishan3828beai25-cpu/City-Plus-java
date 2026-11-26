package citypulse;

public class ExceptionHandler {
    public void showMessage(Exception exception) {
        System.out.println("Operation could not be completed: " + exception.getMessage());
    }
}
