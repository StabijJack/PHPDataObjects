package nl.famschneider.phpdataobjects.datamodel;

import nl.famschneider.phpdataobjects.datamodel.PHPDataNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataNullTest {
    private PHPDataNull phpDataNull;

    @BeforeEach
    void setUp() {
        phpDataNull = new PHPDataNull();
    }

    @Test
    void testtoString() {
        assertEquals("N", phpDataNull.serializeToFormat(InputFormat.ARRAY));
    }

    @Test
    void getValue() {
        assertNull(phpDataNull.getValue());
    }

    @Test
    void getValueClass() {
        assertNull(phpDataNull.getValue());
    }

}