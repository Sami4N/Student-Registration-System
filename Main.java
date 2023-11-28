import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean check = true;
    static boolean isRegular = false, isAdmin, isAdminWork;
    static Scanner input = new Scanner(System.in);
    static int indexOfCourse;

    static ArrayList<String> departments = new ArrayList<>(List.of(
            "Computer Science", "Information Science", "Information System", "Information Technology", "Software Engineering"));

    public static void registerStudent() { // Method to register a new student
        String sName, sId;
        Regular regular;
        Distance distance;
        while (true) {
            System.out.print("Student's ID number: ");
            sId = input.next();
            input.nextLine();  // Consume newline character left by previous input.nextInt()

            // Check if the entered ID is registered in either regular or distance student lists
            String finalSId = sId;
            boolean isIdRegistered = Regular.regularStudentList.stream().anyMatch(student -> student.getStudentId().equalsIgnoreCase((finalSId)))
                    || Distance.distanceStudentList.stream().anyMatch(student -> student.getStudentId().equalsIgnoreCase((finalSId)));

            if (!isIdRegistered) {
                break;
            } else {
                System.out.println("ID " + sId + " has been registered previously!\nPlease enter the correct ID number:");
            }
        }
        while (true) {
            try {
                System.out.print(" Student's Name    : ");
                sName = input.nextLine();
                if (!sName.matches("[a-zA-Z\\s]+")) // Check if the entered name only letter
                    throw new IllegalArgumentException();
                break;
            } catch (IllegalArgumentException e) { // If the entered name is invalid, display an error message
                System.out.println("Invalid name:\nName can only contain letters (A-Z)");
            }
        }
        while (true){
            try {
                System.out.println(" Select Student's major: ");
                for (int i = 0; i < departments.size(); i++) { // Display departments
                    System.out.println("   " + (i + 1) + ". " + departments.get(i));
                }
                int sMajor = input.nextInt();
                if (!(sMajor >= 1 && sMajor <= 5)) // Check if the input is within the valid range
                    throw new IndexOutOfBoundsException();
                if (isRegular) { // add to the regular list
                    regular = new Regular(sName, sId, departments.get((sMajor) - 1));
                    Regular.addToList(regular);
                } else {  // add to the distance list
                    distance = new Distance(sName, sId, departments.get((sMajor) - 1));
                    Distance.addToList(distance);
                }
                indexOfCourse = sMajor - 1;
                break;
            } catch (IndexOutOfBoundsException | InputMismatchException e){
                System.out.println("Invalid Input!\nPlease try again:");
                input.nextLine();
            }
        }
        System.out.println("REGISTERED! \nStudent " + sName.toUpperCase() +" has been registered for this semester, successfully.");
        System.out.println("-----------------------------------------------------------");
        if (!isAdmin) {
            System.out.println("    1. Collect your slip.\n    2. Continue\n    3. Back to main\n    4. Exit");
            String choice3 = input.next();
            if (choice3.equals("1")) { // Display student slip
                if (isRegular) {
                    Regular.regularStudentList.get(Regular.regularStudentList.size() - 1).studentSlip("Regular");
                } else {
                    Distance.distanceStudentList.get(Distance.distanceStudentList.size() - 1).studentSlip("Distance");
                }
                System.out.println("    1. Continue\n    2. Back to main\n    3. Exit");
                String choice4 = input.next();
                if (choice4.equals("1")) {
                    registerStudent();
                } else if (choice4.equals("2")) {
                    check = true;
                } else if (choice4.equals("3")) {
                    check = false;
                } else {
                    System.err.println("Invalid input!");
                }
            } else if (choice3.equals("2")) {
                registerStudent();
            } else if (choice3.equals("3")) {
                check = true;
            } else if (choice3.equals("4")) {
                check = false;
                System.out.println("Program terminated!");
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
    static void option(){
        System.out.println("    1. Continue\n    2. Back to main\n    3. Exit");
        String choice7 = input.next();
        if (choice7.equals("1")) {

        } else if (choice7.equals("2")) {
            isAdminWork = false;
        } else if (choice7.equals("3")) {
            System.out.println("Program terminated");
            System.exit(0);
        } else {
            System.err.println("Invalid input!");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n****************************************************************");
        System.out.println("            COLLEGE OF COMPUTING AND INFORMATICS(CCI)");
        System.out.println("                   STUDENT REGISTRATION SYSTEM");
        System.out.println("****************************************************************");
        while (check) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("    1. Student\n    2. Admin\n    3. Exit");
            String choice = input.next();
            if (choice.equals("1")) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("    1. Regular Student\n    2. Distance Student");
                String choice1 = input.next();
                if (choice1.equals("1")) {
                    isRegular = true;
                    registerStudent();
                } else if (choice1.equals("2")) {
                    isRegular = false;
                    registerStudent();
                } else System.out.println("Invalid Input!");
            } else if (choice.equals("2")) {
                isAdminWork = true;
                while (isAdminWork) {
                    System.out.println("    1. Display Registered students.\n    2. Register new student\n    3. Delete Registered students.\n    4. Back to main.\n    5. Exit");
                    String choice4 = input.next();
                    if (choice4.equals("1")) {
                        Regular.displayRegularStudent();
                        Distance.displayDistanceStudent();
                        option();
                    } else if (choice4.equals("2")) {
                        isAdmin = true;
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("    1. Regular Student\n    2. Distance Student");
                        String choice5 = input.next();
                        if (choice5.equals("1")) {
                            isRegular = true;
                            registerStudent();
                        } else if (choice5.equals("2")) {
                            isRegular = false;
                            registerStudent();
                        } else
                            System.out.println("Invalid input!");
                        option();
                    } else if (choice4.equals("3")) {
                        System.out.println("    1. Delete Regular Student\n    2. Delete Distance Student");
                        String choice5 = input.next();
                        System.out.print("Enter Student ID to delete: ");
                        input.nextLine();
                        String studentIdToDelete = input.next();
                        if (choice5.equals("1"))
                            Regular.deleteRegularStudent(studentIdToDelete);
                        else if (choice5.equals("2"))
                            Distance.deleteDistanceStudent(studentIdToDelete);
                        else
                            System.out.println("Invalid input!");
                        option();
                    } else if (choice4.equals("4")) {
                        isAdminWork = false;
                    } else if (choice4.equals("5")) {
                        System.out.println("Program terminated");
                        System.exit(0);
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            } else if (choice.equals("3")) {
                System.out.println("Program terminated");
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}

