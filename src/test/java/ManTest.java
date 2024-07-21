import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class ManTest {
    private Man man;

    @BeforeEach
    public void setUp() {
        man = new Man("John", "Doe", 30);
    }

    static Stream<String> firstNameProvider() {
        return Stream.of("John", "Mike", "Bob");
    }

    static Stream<String> lastNameProvider() {
        return Stream.of("Doe", "Smith", "Johnson");
    }

    static Stream<Integer> ageProvider() {
        return Stream.of(30, 40, 66);
    }

    @ParameterizedTest
    @MethodSource("firstNameProvider")
    public void testSetFirstName(String firstName) {
        man.setFirstName(firstName);
        assertEquals(firstName, man.getFirstName());
    }

    @ParameterizedTest
    @MethodSource("lastNameProvider")
    public void testSetLastName(String lastName) {
        man.setLastName(lastName);
        assertEquals(lastName, man.getLastName());
    }

    @ParameterizedTest
    @MethodSource("ageProvider")
    public void testSetAge(int age) {
        man.setAge(age);
        assertEquals(age, man.getAge());
    }

    @Test
    public void testIsRetired() {
        man.setAge(66);
        assertTrue(man.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Woman woman = new Woman("Jane", "Smith", 25);
        man.registerPartnership(woman);
        assertEquals(woman, man.partner);
    }

    @Test
    public void testDeregisterPartnership() {
        Woman woman = new Woman("Jane", "Smith", 25);
        man.registerPartnership(woman);
        man.deregisterPartnership(true);
        assertNull(man.partner);
    }
}

