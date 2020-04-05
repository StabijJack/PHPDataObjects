package nl.famschneider.phpdataobjects.datamodel;

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
    void testtoString() {
        assertEquals("s:6:\"va\"lue\"",phpDataString.serializeToFormat(PHPDataSerializeFormat.ARRAY));
    }

    @Test
    void getValue() {
        assertEquals("va\"lue", phpDataString.getValue());
    }

    @Test
    void getValueClass() {
        assertNotNull(phpDataString.getValue());
    }

}