import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class WomanTest {
    private Woman woman;

    @BeforeEach
    public void setUp() {
        woman = new Woman("Jane", "Doe", 30);
    }

    static Stream<String> firstNameProvider() {
        return Stream.of("Jane", "Anna", "Emma");
    }

    static Stream<String> lastNameProvider() {
        return Stream.of("Doe", "Smith", "Johnson");
    }

    static Stream<Integer> ageProvider() {
        return Stream.of(30, 40, 61);
    }

    @ParameterizedTest
    @MethodSource("firstNameProvider")
    public void testSetFirstName(String firstName) {
        woman.setFirstName(firstName);
        assertEquals(firstName, woman.getFirstName());
    }

    @ParameterizedTest
    @MethodSource("lastNameProvider")
    public void testSetLastName(String lastName) {
        woman.setLastName(lastName);
        assertEquals(lastName, woman.getLastName());
    }

    @ParameterizedTest
    @MethodSource("ageProvider")
    public void testSetAge(int age) {
        woman.setAge(age);
        assertEquals(age, woman.getAge());
    }

    @Test
    public void testIsRetired() {
        woman.setAge(61);
        assertTrue(woman.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Man man = new Man("John", "Smith", 25);
        woman.registerPartnership(man);
        assertEquals(man, woman.partner);
    }

    @Test
    public void testDeregisterPartnership() {
        Man man = new Man("John", "Smith", 25);
        woman.registerPartnership(man);
        woman.deregisterPartnership(true);
        assertNull(woman.partner);
    }
}
