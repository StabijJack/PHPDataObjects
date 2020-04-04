package nl.famschneider.phpdataobjects.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataElementNameTest {
    PHPDataElementName phpDataElementNameString;
    PHPDataElementName phpDataElementNameInteger;

    @BeforeEach
    void setUp() {
        phpDataElementNameString = new PHPDataElementName(new PHPDataString("string"));
        phpDataElementNameInteger = new PHPDataElementName(new PHPDataInteger(1));

    }

    @Test
    void getPHPDataType() {
        assertTrue(phpDataElementNameInteger.getPHPDataType() instanceof PHPDataInteger);
        assertTrue(phpDataElementNameString.getPHPDataType() instanceof PHPDataString);
    }

    @Test
    void getName() throws PHPDataModelException {
        assertEquals("string",phpDataElementNameString.getName());
        assertEquals("1",phpDataElementNameInteger.getName());
    }

    @Test
    void getNumber() throws PHPDataModelException {
        assertThrows(PHPDataModelException.class,()-> phpDataElementNameString.getNumber());
        assertEquals(1,phpDataElementNameInteger.getNumber());
    }

    @Test
    void testtoString() throws PHPDataModelException {
        assertEquals("s:6:\"string\"", phpDataElementNameString.serializeToFormat(InputFormat.ARRAY));
        assertEquals("i:1", phpDataElementNameInteger.serializeToFormat(InputFormat.ARRAY));
    }
}