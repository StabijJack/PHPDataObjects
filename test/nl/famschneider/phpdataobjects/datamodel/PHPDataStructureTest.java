package nl.famschneider.phpdataobjects.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PHPDataStructureTest {
    private PHPDataStructure phpDataStructure1;
    private PHPDataStructure phpDataStructure2;

    @BeforeEach
    void setUp() {
        phpDataStructure1 = new PHPDataStructure();
        phpDataStructure2 = new PHPDataStructure(new ArrayList<>());
    }

    @Test
    void add() {
        List<PHPDataElement> phpDataElementList = new ArrayList<>();
        PHPDataElement phpDataElement1 = new PHPDataElement(new PHPDataElementName(new PHPDataString("name of \"first element")), new PHPDataString("value of first element"));
        PHPDataElement phpDataElement2 = new PHPDataElement(new PHPDataElementName(new PHPDataString("name of second element")), new PHPDataString("value of second element"));
        phpDataElementList.add(phpDataElement1);
        phpDataElementList.add(phpDataElement2);
        phpDataStructure1.add(phpDataElement1);
        phpDataStructure1.add(phpDataElement2);
        assertEquals(2, phpDataElementList.size());
        assertEquals("s:22:\"name of \"first element\";s:22:\"value of first element\";s:22:\"name of second element\";s:23:\"value of second element\";", phpDataStructure1.toString());

    }
    @Test
    void numberedArray(){
        List<PHPDataElement> phpDataElementList = new ArrayList<>();
        PHPDataElement phpDataElement1 = new PHPDataElement(new PHPDataElementName(new PHPDataInteger(0)), new PHPDataString("value of first element"));
        PHPDataElement phpDataElement2 = new PHPDataElement(new PHPDataElementName(new PHPDataInteger(1)), new PHPDataString("value of second element"));
        phpDataElementList.add(phpDataElement1);
        phpDataElementList.add(phpDataElement2);
        phpDataStructure1.add(phpDataElement1);
        phpDataStructure1.add(phpDataElement2);
        assertEquals(2, phpDataElementList.size());
        assertEquals("i:0;s:22:\"value of first element\";i:1;s:23:\"value of second element\";", phpDataStructure1.toString());
    }
    @Test
    void testToString() {
        assertEquals("", phpDataStructure1.toString());
        assertEquals("", phpDataStructure2.toString());
        List<PHPDataElement> phpDataElementList = new ArrayList<>();
        PHPDataElement phpDataElement1 = new PHPDataElement(new PHPDataElementName( new PHPDataString("1")), new PHPDataString("1v"));
        PHPDataElement phpDataElement2 = new PHPDataElement(new PHPDataElementName( new PHPDataString("2")), new PHPDataString("2v"));
        phpDataElementList.add(phpDataElement1);
        phpDataElementList.add(phpDataElement2);
        phpDataStructure1.add(phpDataElement1);
        phpDataStructure1.add(phpDataElement2);
        assertEquals(2, phpDataElementList.size());
        assertEquals("s:1:\"1\";s:2:\"1v\";s:1:\"2\";s:2:\"2v\";", phpDataStructure1.toString());
    }

    @Test
    void getPhpDataElementList() {
        assertEquals(0, phpDataStructure1.getPhpDataElementList().size());
    }

    @Test
    void size() {

        assertEquals(0, phpDataStructure1.size());
    }
}