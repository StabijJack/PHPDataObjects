public class PHPDataElement {

    // "name";"value"
    // "name" is a PHPString
    // "value" is a PHPDataElementType
    private final PHPDataString name;
    private final PHPDataType value;
    @SuppressWarnings("FieldCanBeLocal")
    private final String separator = ";";

    public PHPDataElement(PHPDataString name, PHPDataType value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name.toString() + separator + value.toString();
    }

    public PHPDataString getName() {
        return name;
    }

    public PHPDataType getValue() {
        return value;
    }
}
