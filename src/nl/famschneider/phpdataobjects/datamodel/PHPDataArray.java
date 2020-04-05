package nl.famschneider.phpdataobjects.datamodel;

import java.util.ArrayList;
import java.util.List;

public class PHPDataArray extends PHPDataType {
    //a:99:{PHPDataElement;PHPDataElement; .....}
    //between {} isEqual to a PHPStructure.
    //a:identifies array
    //99 number of PHPDataElements

    private final List<PHPDataElement> phpDataElementList;

    public PHPDataArray() {
        this(new ArrayList<>());
    }

    public PHPDataArray(List<PHPDataElement> value) {
        super();
        type = "a";
        this.phpDataElementList = value;
    }

    public void add(PHPDataElement phpDataElement) {
        phpDataElementList.add(phpDataElement);
    }

    public List<PHPDataElement> getValue() {
        return phpDataElementList;
    }

    public String serializeToFormat(PHPDataSerializeFormat phpDataSerializeFormat) {
        if (phpDataSerializeFormat == PHPDataSerializeFormat.ARRAY) {
            PHPDataStructure phpDataStructure = new PHPDataStructure(phpDataElementList);
            return type +
                    separator +
                    phpDataElementList.size() +
                    separator +
                    "{" +
                    phpDataStructure.serializeToFormat(phpDataSerializeFormat) +
                    "}";
        } else if (phpDataSerializeFormat == PHPDataSerializeFormat.STRUCTURE) {
            PHPDataStructure phpDataStructure = new PHPDataStructure(phpDataElementList);
            return "{" +
                    phpDataStructure.serializeToFormat(phpDataSerializeFormat) +
                    "}";
        } else {
            return "";
        }
    }

}
