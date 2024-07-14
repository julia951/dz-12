import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManTest {
    private Man man;

    @BeforeEach
    public void setUp() {
        man = new Man("John", "Doe", 30);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", man.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        man.setFirstName("Mike");
        assertEquals("Mike", man.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", man.getLastName());
    }

    @Test
    public void testSetLastName() {
        man.setLastName("Smith");
        assertEquals("Smith", man.getLastName());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, man.getAge());
    }

    @Test
    public void testSetAge() {
        man.setAge(40);
        assertEquals(40, man.getAge());
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
