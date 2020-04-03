package nl.famschneider.phpdataobjects.datamodel;

import java.util.ArrayList;
import java.util.List;

public class PHPDataStructure {
    //PHPDataElement;PHPDataElement, ....

    private final List<PHPDataElement> phpDataElementList;

    ;
    private final String PHPDataElementSeparator = ";";
    private InputFormat inputFormat;

    public PHPDataStructure() {
        this(new ArrayList<>(), InputFormat.ARRAY);
    }

    public PHPDataStructure(InputFormat inputFormat) {
        this(new ArrayList<>(), inputFormat);
    }

    public PHPDataStructure(List<PHPDataElement> phpDataElementList) {
        this(phpDataElementList, InputFormat.ARRAY);
    }
    public PHPDataStructure(List<PHPDataElement> phpDataElementList, InputFormat inputFormat) {
        this.phpDataElementList = phpDataElementList;
        this.inputFormat = inputFormat;
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
        return stringBuilder.toString();
    }

    public String toString(InputFormat inputFormat) {
        if (inputFormat == InputFormat.ARRAY) {
            return toString();
        } else if (inputFormat == InputFormat.STRUCTURE) {
            StringBuilder stringBuilder = new StringBuilder();
            phpDataElementList.forEach(phpDataElement -> {
                try {
                    stringBuilder.append(phpDataElement.toString(inputFormat));
                } catch (PHPDataModelException e) {
                    stringBuilder.append(e.getMessage());
                }
                stringBuilder.append(PHPDataElementSeparator);
            });
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

    public int size() {
        return phpDataElementList.size();
    }
}
