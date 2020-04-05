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
        return value.toString();
    }

    public String serializeToFormat(PHPDataSerializeFormat phpDataSerializeFormat) {
        if (phpDataSerializeFormat == PHPDataSerializeFormat.ARRAY) {
            return type +
                    separator +
                    value;
        } else if (phpDataSerializeFormat == PHPDataSerializeFormat.STRUCTURE) {
            return value.toString();
        } else {
            return "";
        }
    }

    public Double getValue(){
        return value;
    }
}
