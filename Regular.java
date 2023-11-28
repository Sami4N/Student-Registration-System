import java.util.ArrayList;
import java.util.Scanner;

class Regular extends Student {
    static ArrayList<Regular> regularStudentList = new ArrayList<>();
    public Regular(String studentName, String studentId, String department) {
        super(studentName, studentId, department);
    }

    public static void addToList(Regular regular) {   // Method to add a regular student to the list
        regularStudentList.add(regular);
    }

    public static void deleteRegularStudent(String studentId) {     // Method to delete a regular student from the list
        for (Regular student : regularStudentList) {
            if (student.getStudentId().equals(studentId)) {
                regularStudentList.remove(student);
                System.out.println("Regular student with ID " + studentId + " deleted successfully.");
                System.out.println("----------------------------------------------------------------");
                return;
            }
        }
        System.out.println("Regular student with ID " + studentId + " not found.");
    }

    public static void displayRegularStudent() {     // Method to display the list of regular students
        System.out.println("----------------------------------------------------------------");
        if (regularStudentList.isEmpty())
            System.out.println("            No regular students are registered.");
        else {
            System.out.println("                   ---| Regular Students |---");
            System.out.println(".----------------------------------------------------------------");
            System.out.println("  #   ID                  NAME                   DEPARTMENT");
            System.out.println("----------------------------------------------------------------");
            int i = 1;
            for (Regular student : regularStudentList) {
                System.out.println("  " + i + ".\t" + student.getStudentId() + "\t\t\t" + student.getStudentName().toUpperCase() + "\t\t\t" + student.getMajor());
                i++;
            }
        }
        System.out.println("----------------------------------------------------------------");
    }
}