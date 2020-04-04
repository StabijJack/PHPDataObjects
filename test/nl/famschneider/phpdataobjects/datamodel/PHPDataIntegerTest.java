package nl.famschneider.phpdataobjects.datamodel;

import nl.famschneider.phpdataobjects.datamodel.PHPDataInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataIntegerTest {
private PHPDataInteger phpDataInteger;
    @BeforeEach
    void setUp() {
        phpDataInteger = new PHPDataInteger(555);
    }

    @Test
    void testtoString() {
        assertEquals("i:555", phpDataInteger.serializeToFormat(InputFormat.ARRAY));
    }

    @Test
    void getValue() {
        assertEquals(555,phpDataInteger.getValue());
    }
    @Test
    void getValueClass() {
        assertNotNull(phpDataInteger.getValue());
    }

}