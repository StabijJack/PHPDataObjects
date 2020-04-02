package nl.famschneider.phpdataobjects.datamodel;

import java.util.ArrayList;
import java.util.List;

public class PHPDataStructure {
    //PHPDataElement;PHPDataElement, ....

    private final List<PHPDataElement> phpDataElementList;
    private final String PHPDataElementSeparator = ";";

    public PHPDataStructure() {
        this(new ArrayList<>());
    }

    public PHPDataStructure(List<PHPDataElement> phpDataElementList) {
        this.phpDataElementList = phpDataElementList;
    }

    public void add(PHPDataElement phpDataElement) {
        phpDataElementList.add(phpDataElement);
    }
    public List<PHPDataElement> getPhpDataElementList() {
        return phpDataElementList;
    }

    @Override
    public String toString() {
        if (phpDataElementList.size() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        phpDataElementList.forEach(phpDataElement -> {
            stringBuilder.append(phpDataElement.toString());
            stringBuilder.append(PHPDataElementSeparator);
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
    public int size(){
        return phpDataElementList.size();
    }
}
