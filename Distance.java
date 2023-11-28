import java.util.ArrayList;

class Distance extends Student {
    static ArrayList<Distance> distanceStudentList = new ArrayList<>();

    public Distance(String studentName, String studentId, String department) {
        super(studentName, studentId, department);
    }

    public static void addToList(Distance distance) { // Method to add a distance student to the list
        distanceStudentList.add(distance);
    }

    public static void deleteDistanceStudent(String studentId) { // Method to delete a distance student from the list
        for (Distance student : distanceStudentList) {
            if (student.getStudentId().equals(studentId)) {
                distanceStudentList.remove(student);
                System.out.println("Regular student with ID " + studentId + " deleted successfully.");
                System.out.println("----------------------------------------------------------------");
                return;
            }
        }
        System.out.println("Regular student with ID " + studentId + " not found.");
    }

    public static void displayDistanceStudent() {  // Method to display the list of distance students
        System.out.println("----------------------------------------------------------------");
        if (distanceStudentList.isEmpty())
            System.out.println("            No distance students are registered.");
        else {
            System.out.println("                   ---| Distance Students |---");
            System.out.println("----------------------------------------------------------------");
            System.out.println("#   ID                     NAME              DEPARTMENT");
            System.out.println("----------------------------------------------------------------");
            int i = 1;
            for (Distance student : distanceStudentList) {
                System.out.println(i + ".\t" + student.getStudentId() + "\t\t\t" + student.getStudentName().toUpperCase() + "\t\t\t" + student.getMajor());
                i++;
            }
        }
        System.out.println("----------------------------------------------------------------");
    }
}
