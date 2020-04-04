package nl.famschneider.phpdataobjects.datamodel;

import nl.famschneider.phpdataobjects.PHPDataDeSerializer;
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
        assertEquals("s:22:\"name of \"first element\";s:22:\"value of first element\";s:22:\"name of second element\";s:23:\"value of second element\";", phpDataStructure1.serializeToFormat(InputFormat.ARRAY));

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
        assertEquals("i:0;s:22:\"value of first element\";i:1;s:23:\"value of second element\";", phpDataStructure1.serializeToFormat(InputFormat.ARRAY));
    }
    @Test
    void testtoString() {
        assertEquals("", phpDataStructure1.serializeToFormat(InputFormat.ARRAY));
        assertEquals("", phpDataStructure2.serializeToFormat(InputFormat.ARRAY));
        List<PHPDataElement> phpDataElementList = new ArrayList<>();
        PHPDataElement phpDataElement1 = new PHPDataElement(new PHPDataElementName( new PHPDataString("1")), new PHPDataString("1v"));
        PHPDataElement phpDataElement2 = new PHPDataElement(new PHPDataElementName( new PHPDataString("2")), new PHPDataString("2v"));
        phpDataElementList.add(phpDataElement1);
        phpDataElementList.add(phpDataElement2);
        phpDataStructure1.add(phpDataElement1);
        phpDataStructure1.add(phpDataElement2);
        assertEquals(2, phpDataElementList.size());
        assertEquals("s:1:\"1\";s:2:\"1v\";s:1:\"2\";s:2:\"2v\";", phpDataStructure1.serializeToFormat(InputFormat.ARRAY));
    }

    @Test
    void arrayDepth() throws PHPDataModelException {
        String PHPTestStructure1 = "{\"array1\"={\"array2\"={\"valuefield\"=null}}}";
        PHPDataStructure phpDataStructure1 = new PHPDataDeSerializer(PHPTestStructure1).getPhpDataStructure();
        assertEquals(5, phpDataStructure1.arrayDepth());

        String PHPTestStructure2 = "{\"array1\"={\"array2\"={\"array3\"={\"valuefield\"=null}}}\"array1\"={\"array2\"={\"valuefield\"=null}}}";
        PHPDataStructure phpDataStructure2 = new PHPDataDeSerializer(PHPTestStructure2).getPhpDataStructure();
        assertEquals(6, phpDataStructure2.arrayDepth());
    }

    @Test
    void arrayWidth() throws PHPDataModelException {
        String PHPTestStructure1 = "{\"array1\"={\"array2\"={\"valuefield\"=null}}}";
        PHPDataStructure phpDataStructure1 = new PHPDataDeSerializer(PHPTestStructure1).getPhpDataStructure();
        assertEquals(1, phpDataStructure1.arrayWidth());

        String PHPTestStructure2 = "{\"array1\"={\"array2\"={\"array3\"={\"valuefield\"=null}}}\"array1\"={\"array2\"={\"valuefield\"=null}}}";
        PHPDataStructure phpDataStructure2 = new PHPDataDeSerializer(PHPTestStructure2).getPhpDataStructure();
        assertEquals(2, phpDataStructure2.arrayWidth());
    }

    @Test
    void exportDataArray() throws PHPDataModelException {
        String PHPTestStructure1 = "{\"oarray1\"={\"oarray2\"={\"oarray3\"={\"0valuefield\"=0null}}}\"1array1\"={\"1array2\"={\"1valuefield\"=1null}}}";
        PHPDataStructure phpDataStructure1 = new PHPDataDeSerializer(PHPTestStructure1).getPhpDataStructure();
        String[][] t = phpDataStructure1.getExportDataArray();
    }
}