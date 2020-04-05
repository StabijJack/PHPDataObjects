package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataBoolean extends PHPDataType {
    //b:0
    //b identifies String
    //0 actual value
    private final Boolean value;

    public PHPDataBoolean(Boolean value) {
        super();
        super.type = "b";
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String serializeToFormat(PHPDataSerializeFormat phpDataSerializeFormat) {
        if (phpDataSerializeFormat == PHPDataSerializeFormat.ARRAY) {
            return type +
                    separator +
                    (value ? "1" : "0");
        } else if (phpDataSerializeFormat == PHPDataSerializeFormat.STRUCTURE) {
            return value.toString();
        } else {
            return "";
        }
    }

    public Boolean getValue() {
        return value;
    }
}
