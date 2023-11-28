import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    void testStudentSlip() {
        Student student = new Student("Samuel Negasa", "1212", "Software Engineering");
        student.studentSlip("Regular");
    }

    @Test
    void testGetters() {
        Student student = new Student("Misgana", "5555", "Information Science");
        assertEquals("Misgana", student.getStudentName());
        assertEquals("5555", student.getStudentId());
        assertEquals("Information Science", student.getMajor());
    }

    @Test
    void testAddToList() {
        Regular regular = new Regular("Samuel Negasa", "1212", "Software Engineering");
        Regular.addToList(regular);
        assertFalse(Regular.regularStudentList.isEmpty()); // Assert that the regular student list is not empty after adding a student
    }

    @Test
    void testDeleteRegularStudent() {
        Regular regular = new Regular("Oriemi Obang", "2222", "Computer Science");
        Regular.addToList(regular);
        Regular.deleteRegularStudent("2222");
        assertTrue(Regular.regularStudentList.isEmpty()); // Assert that the regular student list is empty after deleting the student
    }

    @Test
    void testDisplayRegularStudent() {
        Regular regular = new Regular("Naol lemessa", "3333", "Software Engineering");
        Regular.addToList(regular);
        Regular.displayRegularStudent();
    }

    @Test
    void testDeleteDistanceStudent() {
        Distance distance = new Distance("kirubel amare", "4444", "Information Science");
        Distance.addToList(distance);
        Distance.deleteDistanceStudent("4444");
    }
}

