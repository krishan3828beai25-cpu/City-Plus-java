package citypulse;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner = new Scanner(System.in);

    public String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid non-negative number.");
            }
        }
    }
}
