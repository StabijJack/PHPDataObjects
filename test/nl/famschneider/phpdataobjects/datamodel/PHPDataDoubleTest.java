package nl.famschneider.phpdataobjects.datamodel;

import nl.famschneider.phpdataobjects.datamodel.PHPDataDouble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PHPDataDoubleTest {
    private PHPDataDouble phpDataDouble;

    @BeforeEach
    void setUp() {
        phpDataDouble = new PHPDataDouble(555.009);
    }

    @Test
    void testToString() {
        assertEquals("d:555.009", phpDataDouble.toString());
    }

    @Test
    void getValue() {
        assertEquals(555.009, phpDataDouble.getValue());
    }

    @Test
    void getValueClass() {
        assertNotNull(phpDataDouble.getValue());
    }

}