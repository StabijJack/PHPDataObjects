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
        String stringBuilder = type +
                separator +
                value.length() +
                separator +
                quote +
                value +
                quote;
        return stringBuilder;
    }
    public String getValue(){
        return value;
    }
}
