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

    public String serializeToFormat(InputFormat inputFormat) {
        if (inputFormat == InputFormat.ARRAY) {
            return type +
                    separator +
                    (value ? "1" : "0");
        } else if (inputFormat == InputFormat.STRUCTURE) {
            return value.toString();
        } else {
            return "";
        }
    }

    public Boolean getValue() {
        return value;
    }
}
