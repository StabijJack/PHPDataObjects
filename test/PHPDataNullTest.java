import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PHPDataNullTest {
    private PHPDataNull phpDataNull;

    @BeforeEach
    void setUp() {
        phpDataNull = new PHPDataNull();
    }

    @Test
    void testToString() {
        assertEquals("N", phpDataNull.toString());
    }

    @Test
    void getValue() {
        assertEquals(null, phpDataNull.getValue());
    }

    @Test
    void getValueClass() {
        assertTrue(phpDataNull.getValue() == null);
    }

}