
import java.util.Scanner;

public class Login {
    private User user;

    public Login() {
        //default username and password
        user = new User("admin", "password123");
    }

    public boolean authenticate(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials! Please try again.");
            return false;
        }
    }

    public void updateProfile(Scanner scanner) {
        System.out.println("Update your profile:");
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        user.setUsername(newUsername);
        user.setPassword(newPassword);
        System.out.println("Profile updated successfully!");
    }
}
