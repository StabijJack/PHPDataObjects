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
        return type +
                separator +
                (value ? "1" : "0");
    }

    public String toString(InputFormat inputFormat) {
        if (inputFormat == InputFormat.ARRAY) {
            return toString();
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
