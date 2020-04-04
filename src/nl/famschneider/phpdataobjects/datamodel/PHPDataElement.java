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

    public String serializeToFormat(InputFormat inputFormat) throws PHPDataModelException {
        if (inputFormat == InputFormat.ARRAY) {
            return name.serializeToFormat(inputFormat) + separator + value.serializeToFormat(inputFormat);
        } else if (inputFormat == InputFormat.STRUCTURE) {
            return name.serializeToFormat(inputFormat) + "=" + value.serializeToFormat(inputFormat);
        } else {
            return "";
        }
    }

    @SuppressWarnings("unused")
    public PHPDataElementName getPHPElementName() {
        return name;
    }

    public String getName() throws PHPDataModelException {
        return name.getName();
    }

    public Integer getNumber() throws PHPDataModelException {
        return name.getNumber();
    }

    public PHPDataType getValue() {
        return value;
    }
}
