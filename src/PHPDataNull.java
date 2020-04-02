public class PHPDataNull extends PHPDataType {
    //N
    public PHPDataNull() {
        super();
        super.type = "N";
    }

    @Override
    public String toString() {
        String stringBuilder = type;
        return stringBuilder;
    }
    public Object getValue(){
        return null;
    }
}
