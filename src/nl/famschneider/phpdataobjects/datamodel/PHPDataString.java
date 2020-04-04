package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataString extends PHPDataType {
    //s:99:"string"
    //s identifies String
    //99 length of String
    //String actual value
    private final String value;
    protected final String quote = "\"";

    public PHPDataString(String value) {
        super();
        super.type = "s";
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String serializeToFormat(InputFormat inputFormat) {
        if (inputFormat == InputFormat.ARRAY) {
            return type +
                    separator +
                    value.length() +
                    separator +
                    quote +
                    value +
                    quote;
        } else if (inputFormat == InputFormat.STRUCTURE) {
            return value;
        } else {
            return "";
        }
    }

    public String getValue(){
        return value;
    }
}
