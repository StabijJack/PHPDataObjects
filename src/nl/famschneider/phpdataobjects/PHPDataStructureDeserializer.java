package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.*;
import org.jetbrains.annotations.NotNull;

public class PHPDataStructureDeserializer {
    int pointer = 0;

    @SuppressWarnings("FieldCanBeLocal")
    private final String serializedPHPStructure;
    private PHPDataStructure phpDataStructure;

    public PHPDataStructureDeserializer(String serializedPHPStructure) throws PHPDataModelException {
        this.serializedPHPStructure = serializedPHPStructure;
        phpDataStructure = fillPHPDataStructure();
    }

    public PHPDataStructure getPhpDataStructure() {
        return phpDataStructure;
    }

    @NotNull
    private PHPDataStructure fillPHPDataStructure() throws PHPDataModelException {
        PHPDataStructure phpDataStructure = new PHPDataStructure(InputFormat.STRUCTURE);
        phpDataStructure.add(new PHPDataElement(new PHPDataElementName(new PHPDataString("root")), getPHPDataArray()));
        return phpDataStructure;
    }
    @NotNull
    private PHPDataElement getPHPDataElement() throws PHPDataModelException {
        return new PHPDataElement(new PHPDataElementName(getPHPDataString()), getPHPDataType());
    }

    private PHPDataType getPHPDataType() throws PHPDataModelException {
        if (serializedPHPStructure.charAt(pointer)=='{'){
            return getPHPDataArray();
        }
        else{
            return getPHPDataString();
        }
    }
    @NotNull
    private PHPDataArray getPHPDataArray() throws PHPDataModelException {
        PHPDataArray phpDataArray = new PHPDataArray();
        pointer++;//skip {
        while (serializedPHPStructure.charAt(pointer) != '}') {
            phpDataArray.add(getPHPDataElement());
        }
        pointer++; //skip }
        return phpDataArray;
    }

    @NotNull
    private PHPDataString getPHPDataString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (serializedPHPStructure.charAt(pointer) == '"') {
            pointer++; //skip "

            while (serializedPHPStructure.charAt(pointer) != '"') {
                if (serializedPHPStructure.charAt(pointer) == '\\') {
                    pointer++; //skip \
                }
                stringBuilder.append(serializedPHPStructure.charAt(pointer));
                pointer++;
            }
            pointer++; //skip "
            if (serializedPHPStructure.charAt(pointer) == '=') pointer++;

        } else {
            while (serializedPHPStructure.charAt(pointer) != ',' && serializedPHPStructure.charAt(pointer) != '}') {
                stringBuilder.append(serializedPHPStructure.charAt(pointer));
                pointer++;
            }
            if (serializedPHPStructure.charAt(pointer) == ',') pointer++;
        }
        
        return new PHPDataString(stringBuilder.toString());
    }
}