package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PHPDataArrayDeserializer {
    int pointer = 0;
    private final String serializedPHPArray;
    private final PHPDataStructure phpDataStructure;

    public PHPDataArrayDeserializer(String serializedPHPArray) {
        this.serializedPHPArray = serializedPHPArray;
        phpDataStructure = fillPHPDataStructure();
    }

    public PHPDataStructure getPhpDataStructure() {
        return phpDataStructure;
    }

    @NotNull
    private PHPDataStructure fillPHPDataStructure() {
        PHPDataStructure phpDataStructure = new PHPDataStructure();
        phpDataStructure.add(new PHPDataElement(new PHPDataElementName(new PHPDataString("root")), getPHPDataArray()));
        return phpDataStructure;
    }

    @NotNull
    private PHPDataElement getPHPDataElement() {
        switch (serializedPHPArray.charAt(pointer)) {
            case 's':
                return new PHPDataElement(new PHPDataElementName(getPHPDataString()), getPHPDataType());
            case 'i':
                return new PHPDataElement(new PHPDataElementName(getPHPDataInteger()), getPHPDataType());
            default:
                return null;
        }
    }

    @Nullable
    private PHPDataType getPHPDataType() {
        PHPDataType phpDataType;
        switch (serializedPHPArray.charAt(pointer)) {
            case 's': {
                phpDataType = getPHPDataString();
                break;
            }
            case 'b': {
                phpDataType = getPHPDataBoolean();
                break;
            }
            case 'i': {
                phpDataType = getPHPDataInteger();
                break;
            }
            case 'd': {
                phpDataType = getPHPDataDouble();
                break;
            }
            case 'N': {
                phpDataType = getPHPDataNull();
                break;
            }
            case 'a': {
                phpDataType = getPHPDataArray();
                break;
            }
            default: {
                return null;
            }
        }
        return phpDataType;
    }

    @NotNull
    private PHPDataArray getPHPDataArray() {
        PHPDataArray phpDataArray = new PHPDataArray();
        pointer++;//skip a
        pointer++;//skip :
        int arrayLength = getLength();
        pointer++;//skip :
        pointer++;//skip {
        while (arrayLength > 0) {
            phpDataArray.add(getPHPDataElement());
            arrayLength--;
        }
        pointer++; //skip }
        try {
            if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        } catch (StringIndexOutOfBoundsException e) {
            // sometimes there is a ; at the end
        }

        return phpDataArray;
    }

    @NotNull
    private PHPDataString getPHPDataString() {
        pointer++; //skip s
        pointer++; //skip :
        int stringLength = getLength();
        pointer++; //skip :
        pointer++; //skip "
        PHPDataString phpDataString = new PHPDataString(
                serializedPHPArray.substring(pointer, pointer + stringLength)
        );
        pointer += stringLength; //skip string
        pointer++; //skip "
        if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        return phpDataString;
    }

    @NotNull
    private PHPDataBoolean getPHPDataBoolean() {
        pointer++; //skip b
        pointer++; //skip :
        PHPDataBoolean phpDataBoolean = new PHPDataBoolean(Character.getNumericValue(serializedPHPArray.charAt(pointer)) != 0);
        pointer++; //skip value

        if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        return phpDataBoolean;
    }

    @NotNull
    @Contract(" -> new")
    private PHPDataInteger getPHPDataInteger() {
        pointer++; //skip i
        pointer++; //skip :
        int integer = getLength();
        if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        return new PHPDataInteger(integer);
    }

    @NotNull
    @Contract(" -> new")
    private PHPDataDouble getPHPDataDouble() {
        pointer++; //skip d
        pointer++; //skip :
        StringBuilder stringBuilder = new StringBuilder();
        while (serializedPHPArray.charAt(pointer) != ';' && serializedPHPArray.charAt(pointer) != '}') {
            stringBuilder.append(serializedPHPArray.charAt(pointer));
            pointer++;
        }
        if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        return new PHPDataDouble(Double.valueOf(stringBuilder.toString()));
    }

    @NotNull
    @Contract(" -> new")
    private PHPDataNull getPHPDataNull() {
        pointer++; //skip N
        if (serializedPHPArray.charAt(pointer) == ';') pointer++; //skip ;
        return new PHPDataNull();
    }

    private int getLength() {
        int length = Character.getNumericValue(serializedPHPArray.charAt(pointer));
        pointer++;
        while (serializedPHPArray.charAt(pointer) >= '0' && serializedPHPArray.charAt(pointer) <= '9') {
            length = length * 10 + Character.getNumericValue(serializedPHPArray.charAt(pointer));
            pointer++;
        }
        return length;
    }
}
