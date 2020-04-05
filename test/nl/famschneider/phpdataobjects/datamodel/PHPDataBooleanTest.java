package nl.famschneider.phpdataobjects.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataBooleanTest {
    private PHPDataBoolean phpDataBooleanFalse;
    private PHPDataBoolean phpDataBooleanTrue;

    @BeforeEach
    void setUp() {
        phpDataBooleanFalse = new PHPDataBoolean(false);
        phpDataBooleanTrue = new PHPDataBoolean(true);
    }

    @Test
    void testtoString() {
        assertEquals("b:1", phpDataBooleanTrue.serializeToFormat(PHPDataSerializeFormat.ARRAY));
        assertEquals("b:0", phpDataBooleanFalse.serializeToFormat(PHPDataSerializeFormat.ARRAY));
    }

    @Test
    void getValue() {
        assertEquals(true, phpDataBooleanTrue.getValue());
        assertEquals(false, phpDataBooleanFalse.getValue());
    }

    @Test
    void getValueClass() {
        assertNotNull(phpDataBooleanTrue.getValue());
    }

}