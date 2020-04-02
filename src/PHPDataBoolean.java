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
        String stringBuilder = type +
                separator +
                (value ?  "1" :"0");
        return stringBuilder;
    }
    public Boolean getValue(){
        return value;
    }
}
