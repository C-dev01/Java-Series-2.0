import java.util.Scanner;

public class SecurePass {
    // Shared database variables (Hardcoded for simplicity)
    private static final String FIXED_USERNAME = "admin";
    private static final String FIXED_PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attemptsRemaining = 3;
        boolean isAuthenticated = false;

        System.out.println("=== SECUREPASS AUTHENTICATION SYSTEM ===");

        // Loop runs until user runs out of attempts or logs in successfully
        while (attemptsRemaining > 0) {
            System.out.print("Enter Username: ");
            String inputUser = scanner.nextLine();

            System.out.print("Enter Password: ");
            String inputPass = scanner.nextLine();

            // CRITICAL: Using .equals() instead of == for String comparison
            if (inputUser.equals(FIXED_USERNAME) && inputPass.equals(FIXED_PASSWORD)) {
                isAuthenticated = true;
                break; // Exit the loop immediately on success
            } else {
                attemptsRemaining--;
                System.out.println("Invalid credentials! Attempts left: " + attemptsRemaining);
                System.out.println("---------------------------------------");
            }
        }

        // Final status check
        if (isAuthenticated) {
            System.out.println("\nACCESS GRANTED: Welcome to the Admin Dashboard.");
        } else {
            System.out.println("\nACCESS DENIED: Account locked due to multiple failed attempts.");
        }
        scanner.close();
    }
}
