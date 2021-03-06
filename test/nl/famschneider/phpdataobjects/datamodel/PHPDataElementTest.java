package nl.famschneider.phpdataobjects.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataElementTest {
    private PHPDataElement phpDataElement;
    @BeforeEach
    void setUp() {
        phpDataElement = new PHPDataElement(new PHPDataElementName(new PHPDataString("1")), new PHPDataString("1v"));
    }

    @Test
    void testtoString() throws PHPDataModelException {

        assertEquals("s:1:\"1\";s:2:\"1v\"", phpDataElement.serializeToFormat(PHPDataSerializeFormat.ARRAY));
    }

    @Test
    void getName() throws PHPDataModelException {

        assertEquals("1", phpDataElement.getName());
    }

    @Test
    void getValue() {
        assertEquals("1v",((PHPDataString) phpDataElement.getValue()).getValue());
    }

    @Test
    void getValueClass() {
        assertTrue(phpDataElement.getValue() instanceof PHPDataString);
    }
}