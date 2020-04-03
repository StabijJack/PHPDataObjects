package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataDouble extends PHPDataType {
    //d:1234
    //d identifies String
    //1234 actual value
    private final Double value;

    public PHPDataDouble(Double value) {
        super();
        super.type = "d";
        this.value = value;
    }

    @Override
    public String toString() {
        return type +
                separator +
                value;
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

    public Double getValue(){
        return value;
    }
}
