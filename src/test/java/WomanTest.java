import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WomanTest {
    private Woman woman;

    @BeforeEach
    public void setUp() {
        woman = new Woman("Jane", "Doe", 30);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Jane", woman.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        woman.setFirstName("Anna");
        assertEquals("Anna", woman.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", woman.getLastName());
    }

    @Test
    public void testSetLastName() {
        woman.setLastName("Smith");
        assertEquals("Smith", woman.getLastName());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, woman.getAge());
    }

    @Test
    public void testSetAge() {
        woman.setAge(40);
        assertEquals(40, woman.getAge());
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
