import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // try-with-resources ensures scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            EmployeeService service = new EmployeeService();
            boolean running = true;

            while (running) {
                System.out.println("\n=== Employee Management System ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();
                        service.addEmployee(new Employee(id, name, salary, dept));
                    }
                    case 2 -> service.viewEmployees();
                    case 3 -> {
                        System.out.print("Enter ID to update: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter New Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter New Department: ");
                        String dept = scanner.nextLine();
                        service.updateEmployee(id, name, salary, dept);
                    }
                    case 4 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = scanner.nextInt();
                        service.deleteEmployee(id);
                    }
                    case 5 -> {
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
