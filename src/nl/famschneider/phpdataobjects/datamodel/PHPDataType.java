package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataType  {
    protected String type;
    protected final String separator =":";

    public String serializeToFormat(PHPDataSerializeFormat phpDataSerializeFormat) {
        return "PHPDataType{}";
    }

    @Override
    public String toString() {
        return "PHPDataType{}";
    }
}
