package nl.famschneider.phpdataobjects.datamodel;

public class PHPDataElementName {
    private final PHPDataType name;

    public PHPDataElementName(PHPDataString name) {
        this.name = name;
    }

    public PHPDataElementName(PHPDataInteger name) {
        this.name = name;
    }

    public PHPDataType getPHPDataType() {
        return name;
    }

    public String getName() {
        if (name.getClass() == PHPDataString.class) return ((PHPDataString) name).getValue();
        if (name.getClass() == PHPDataInteger.class) return ((PHPDataInteger) name).getValue().toString();
        return null;
    }

    public Integer getNumber() {
        try {
            if (name.getClass() == PHPDataString.class) return Integer.parseInt(((PHPDataString) name).getValue());
        }catch (NumberFormatException e){
            return null;
        }
        if (name.getClass() == PHPDataInteger.class) return ((PHPDataInteger) name).getValue();
        return null;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
