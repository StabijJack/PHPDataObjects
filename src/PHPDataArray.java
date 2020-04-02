import java.util.ArrayList;
import java.util.List;

public class PHPDataArray extends PHPDataType {
    //a:99:{PHPDataElement;PHPDataElement; .....}
    //between {} isEqual to a PHPStructure.
    //a:identifies array
    //99 number of PHPDataElements

    private List<PHPDataElement> phpDataElementList;

    public PHPDataArray() {
        this(new ArrayList());
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

    @Override
    public String toString() {
        PHPDataStructure phpDataStructure = new PHPDataStructure(phpDataElementList);
        String stringBuilder = type +
                separator +
                phpDataElementList.size() +
                separator +
                "{" +
                phpDataStructure.toString() +
                "}";
        return stringBuilder;
    }
}
