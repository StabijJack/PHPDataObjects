package nl.famschneider.phpdataobjects.datamodel;

import nl.famschneider.phpdataobjects.datamodel.PHPDataArray;
import nl.famschneider.phpdataobjects.datamodel.PHPDataElement;
import nl.famschneider.phpdataobjects.datamodel.PHPDataString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PHPDataArrayTest {
    List<PHPDataElement> phpDataElementList;
    private PHPDataArray phpDataArray;

    @BeforeEach
    void setUp() {
        phpDataElementList = new ArrayList<>();
        PHPDataElement phpDataElement1 = new PHPDataElement(new PHPDataElementName(new PHPDataString("name of \"first element")), new PHPDataString("value of first element"));
        PHPDataElement phpDataElement2 = new PHPDataElement(new PHPDataElementName(new PHPDataString("name of second element")), new PHPDataString("value of second element"));
        phpDataElementList.add(phpDataElement1);
        phpDataElementList.add(phpDataElement2);
        phpDataArray = new PHPDataArray();
        phpDataArray.add(phpDataElement1);
        phpDataArray.add(phpDataElement2);
    }

    @Test
    void getValue() {
        assertArrayEquals(phpDataElementList.toArray(), phpDataArray.getValue().toArray());
    }

    @Test
    void testToString() {

        assertEquals("a:2:{s:22:\"name of \"first element\";s:22:\"value of first element\";s:22:\"name of second element\";s:23:\"value of second element\";}", phpDataArray.toString());
    }
}