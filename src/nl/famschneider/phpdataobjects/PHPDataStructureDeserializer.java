package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.PHPDataStructure;

public class PHPDataStructureDeserializer {
    @SuppressWarnings("FieldCanBeLocal")
    private final String serializedPHPStructure;
    private PHPDataStructure phpDataStructure;

    public PHPDataStructureDeserializer(String serializedPHPStructure) {
        this.serializedPHPStructure = serializedPHPStructure;
    }

    public PHPDataStructure getPhpDataStructure() {
        return phpDataStructure;
    }
}
