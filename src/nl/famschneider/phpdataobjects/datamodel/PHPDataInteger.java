package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataInteger extends PHPDataType {
    //i:1234
    //i identifies String
    //1234 actual value
    private final Integer value;

    public PHPDataInteger(Integer value) {
        super();
        super.type = "i";
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
                    value;
        } else if (inputFormat == InputFormat.STRUCTURE) {
            return value.toString();
        } else {
            return "";
        }
    }

    public Integer getValue(){
        return value;
    }
}
