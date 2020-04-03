package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataNull extends PHPDataType {
    //N
    public PHPDataNull() {
        super();
        super.type = "N";
    }

    @Override
    public String toString() {
        return type;
    }

    public String toString(InputFormat inputFormat) {
        if (inputFormat == InputFormat.ARRAY) {
            return toString();
        } else if (inputFormat == InputFormat.STRUCTURE) {
            return type;
        } else {
            return "";
        }
    }

    @SuppressWarnings("SameReturnValue")
    public Object getValue(){
        return null;
    }
}
