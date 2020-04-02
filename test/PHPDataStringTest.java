import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataStringTest {
    private PHPDataString phpDataString;

    @BeforeEach
    void setUp() {
        phpDataString = new PHPDataString("va\"lue");
    }

    @Test
    void testToString() {
        assertEquals("s:6:\"va\"lue\"",phpDataString.toString());
    }

    @Test
    void getValue() {
        assertEquals("va\"lue", phpDataString.getValue());
    }

    @Test
    void getValueClass() {
        assertTrue(phpDataString.getValue() instanceof String);
    }

}