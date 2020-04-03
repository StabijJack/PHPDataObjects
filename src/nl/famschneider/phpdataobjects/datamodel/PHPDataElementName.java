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

    public String getName() throws PHPDataModelException {
        if (name.getClass() == PHPDataString.class) return ((PHPDataString) name).getValue();
        if (name.getClass() == PHPDataInteger.class) return ((PHPDataInteger) name).getValue().toString();
        throw new PHPDataModelException("Not implemented Name PHPDataType");
    }

    public Integer getNumber() throws PHPDataModelException {
        try {
            if (name.getClass() == PHPDataString.class) return Integer.parseInt(((PHPDataString) name).getValue());
        }catch (NumberFormatException e){
            throw new PHPDataModelException("PHPString Contains No number");
        }
        if (name.getClass() == PHPDataInteger.class) return ((PHPDataInteger) name).getValue();
        throw new PHPDataModelException("Not implemented Name PHPDataType");
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
