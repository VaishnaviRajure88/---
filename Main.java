import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Login login = new Login();
        MCQSystem mcqSystem = new MCQSystem();

        boolean loggedIn = false;

        while (true) {
            System.out.println("\nWelcome to the Online Quiz System");
            System.out.println("1. Login");
            System.out.println("2. Update Profile or Password");
            System.out.println("3. Take MCQ Quiz");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();  

            if (!input.matches("[0-5]")) { 
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue; 
            }

            int choice = Integer.parseInt(input);  

            switch (choice) {
                case 1:
                    loggedIn = login.authenticate(scanner); 
                    break;

                case 2:
                    if (loggedIn) {
                        login.updateProfile(scanner); 
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 3:
                    if (loggedIn) {
                        mcqSystem.startQuiz(); // Quiz 
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 4:
                    if (loggedIn) {
                        System.out.println("Logged out successfully.");
                        loggedIn = false;
                    } else {
                        System.out.println("You are not logged in.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Have a Great Day!");
                    scanner.close();  
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


