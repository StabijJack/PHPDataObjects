package nl.famschneider.phpdataobjects.datamodel;

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
        assertEquals("N", phpDataNull.serializeToFormat(PHPDataSerializeFormat.ARRAY));
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