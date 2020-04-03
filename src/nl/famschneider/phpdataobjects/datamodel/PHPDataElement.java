package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataElement {

    // "name";"value"
    // "name" is a PHPString
    // "value" is a PHPDataElementType
    private final PHPDataElementName name;
    private final PHPDataType value;
    @SuppressWarnings("FieldCanBeLocal")
    private final String separator = ";";

    public PHPDataElement(PHPDataElementName name, PHPDataType value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name.toString() + separator + value.toString();
    }

    @SuppressWarnings("unused")
    public PHPDataElementName getPHPElementName(){
        return name;
    }
    public String getName() {
        return name.getName();
    }
    public Integer getNumber() {
        return name.getNumber();
    }

    public PHPDataType getValue() {
        return value;
    }
}
