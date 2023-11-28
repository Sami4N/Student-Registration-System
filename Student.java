import java.util.ArrayList;

class Student {
    private String studentName, studentId, major;

    public Student(String studentName, String studentId, String major) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.major = major;
    }
    String[][] courses = {{"Data structure & Algorithm", "Object-Oriented Programming", "Fundamental of Networking", "Statistics & Probability"},
            {"Data structure & Algorithm", "Computer Organization\t", "Computer Networks\t\t", "Object-Oriented Programming"},
            {"Data structure & Algorithm", "System analysis & Design", "Computer Networks\t\t", "Object-Oriented Programming"},
            {"Data structure & Algorithm", "Internet Programming\t", "Computer Organization\t", "Object-Oriented Programming"},
            {"Data structure & Algorithm", "Operating System\t\t", "Object-Oriented Programming", "Fundamental of Networking"}};
    int[][] creditHour = {{3, 3, 4, 3}, {3, 3, 3, 3}, {3, 3, 3, 3}, {3, 3, 3, 3}, {3, 4, 3, 4}};

    public String getStudentName() {
        return studentName;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getMajor() {
        return major;
    }
    public void studentSlip(String modality) {   // Method to print student registration slip
        System.out.println("**************************************************************************");
        System.out.println("          Haramaya University, Office of the Registrar");
        System.out.println("                  Student Registration Slip");
        System.out.println("**************************************************************************");
        System.out.println("College : College of Computing & Informatics");
        System.out.println("Program : " + getMajor());
        System.out.println("semester : Year II, Semester II (2023/2024)");
        System.out.println("Modality : " + modality + " (B.Sc)");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("ID: " + getStudentId());
        System.out.println("Name: " + getStudentName().toUpperCase());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("**************************************************************************");
        System.out.println("|   # |                   Course Title               |        Cr.Hr.     |");
        System.out.println("--------------------------------------------------------------------------");
        int totalCreditHour = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("|  " + (i+1) + "\t\t" + courses[Main.indexOfCourse][i] + "\t\t\t\t\t\t\t" + creditHour[Main.indexOfCourse][i]);
            totalCreditHour += creditHour[Main.indexOfCourse][i];
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                                               TOTAL  |\t\t\t" + totalCreditHour);
        System.out.println("**************************************************************************");

    }
}
