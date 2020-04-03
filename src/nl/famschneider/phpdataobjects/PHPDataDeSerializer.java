package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.PHPDataStructure;

public class PHPDataDeSerializer {
    private PHPDataStructure phpDataStructure;

    public PHPDataDeSerializer(String serializedPHPObject) {
        if (serializedPHPObject.charAt(0)=='a'){
            phpDataStructure = new PHPDataArrayDeserializer(serializedPHPObject).getPhpDataStructure();
        }
        else if (serializedPHPObject.charAt(0)=='{'){
            phpDataStructure = new PHPDataStructureDeserializer(serializedPHPObject).getPhpDataStructure();
        }
        else{
            System.out.println("An unknown Structure");
        }
    }

    public PHPDataStructure getPhpDataStructure() {
        return phpDataStructure;
    }
}
