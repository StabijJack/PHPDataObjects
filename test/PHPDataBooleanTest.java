import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PHPDataBooleanTest {
    private PHPDataBoolean phpDataBooleanFalse;
    private PHPDataBoolean phpDataBooleanTrue;

    @BeforeEach
    void setUp() {
        phpDataBooleanFalse = new PHPDataBoolean(false);
        phpDataBooleanTrue = new PHPDataBoolean(true);
    }

    @Test
    void testToString() {
        assertEquals("b:1", phpDataBooleanTrue.toString());
        assertEquals("b:0", phpDataBooleanFalse.toString());
    }

    @Test
    void getValue() {
        assertEquals(true, phpDataBooleanTrue.getValue());
        assertEquals(false, phpDataBooleanFalse.getValue());
    }

    @Test
    void getValueClass() {
        assertTrue(phpDataBooleanTrue.getValue() instanceof Boolean);
    }

}