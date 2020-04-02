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
    @SuppressWarnings("SameReturnValue")
    public Object getValue(){
        return null;
    }
}
