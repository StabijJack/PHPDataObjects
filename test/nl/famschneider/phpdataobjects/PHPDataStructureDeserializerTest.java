package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.InputFormat;
import nl.famschneider.phpdataobjects.datamodel.PHPDataModelException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PHPDataStructureDeserializerTest {

    private String PHPTestStructure = "{\"array1\"={\"ar\\\"ray2\"={\"array3\"={\"valu\\\"efield\"=null}}}}";

    @Test
    void getPhpDataStructure() throws PHPDataModelException {

        assertEquals("root={array1={ar\"ray2={array3={valu\"efield=null;};};};};",new PHPDataStructureDeserializer(PHPTestStructure).getPhpDataStructure().toString(InputFormat.STRUCTURE));
    }
}