package nl.famschneider.phpdataobjects.datamodel;

import java.util.ArrayList;
import java.util.List;

public class PHPDataStructure {
    //PHPDataElement;PHPDataElement, ....

    private final List<PHPDataElement> phpDataElementList;
    private final String PHPDataElementSeparator = ";";
    private final PHPDataSerializeFormat phpDataSerializeFormat;

    public PHPDataStructure() {
        this(new ArrayList<>(), PHPDataSerializeFormat.ARRAY);
    }

    public PHPDataStructure(PHPDataSerializeFormat phpDataSerializeFormat) {
        this(new ArrayList<>(), phpDataSerializeFormat);
    }

    public PHPDataStructure(List<PHPDataElement> phpDataElementList) {
        this(phpDataElementList, PHPDataSerializeFormat.ARRAY);
    }

    public PHPDataStructure(List<PHPDataElement> phpDataElementList, PHPDataSerializeFormat phpDataSerializeFormat) {
        this.phpDataElementList = phpDataElementList;
        this.phpDataSerializeFormat = phpDataSerializeFormat;
    }

    public void add(PHPDataElement phpDataElement) {
        phpDataElementList.add(phpDataElement);
    }

    public List<PHPDataElement> getPhpDataElementList() {
        return phpDataElementList;
    }

    public PHPDataSerializeFormat getPHPDataSerializeFormat() {
        return phpDataSerializeFormat;
    }

    public String serializeToFormat(PHPDataSerializeFormat phpDataSerializeFormat) {
        if (phpDataSerializeFormat == PHPDataSerializeFormat.ARRAY) {
            if (phpDataElementList.size() == 0) return "";
            StringBuilder stringBuilder = new StringBuilder();
            phpDataElementList.forEach(phpDataElement -> {
                try {
                    stringBuilder.append(phpDataElement.serializeToFormat(phpDataSerializeFormat));
                } catch (PHPDataModelException e) {
                    e.printStackTrace();
                    stringBuilder.append(e.getMessage());
                }
                stringBuilder.append(PHPDataElementSeparator);
            });
            return stringBuilder.toString();
        } else if (phpDataSerializeFormat == PHPDataSerializeFormat.STRUCTURE) {
            StringBuilder stringBuilder = new StringBuilder();
            phpDataElementList.forEach(phpDataElement -> {
                try {
                    stringBuilder.append(phpDataElement.serializeToFormat(phpDataSerializeFormat));
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

    private int arrayDepth() {
        return arrayDepth(phpDataElementList) + 1; //for value row
    }

    private int arrayDepth(List<PHPDataElement> phpDataElementList) {
        int depth = 1;
        int maxDepthThisLevel = 0;
        for (PHPDataElement phpDataElement : phpDataElementList) {
            int depthThisLevel = 0;
            PHPDataType phpDataType = phpDataElement.getValue();
            if (phpDataType instanceof PHPDataArray) {
                depthThisLevel = arrayDepth(((PHPDataArray) phpDataType).getValue());
            }
            if (depthThisLevel > maxDepthThisLevel) maxDepthThisLevel = depthThisLevel;
        }

        return depth + maxDepthThisLevel;
    }

    private int arrayWidth() {
        return arrayWidth(phpDataElementList);
    }

    private int arrayWidth(List<PHPDataElement> phpDataElementList) {
        int width = 0;
        for (PHPDataElement phpDataElement : phpDataElementList) {
            PHPDataType phpDataType = phpDataElement.getValue();
            if ((phpDataType instanceof PHPDataArray)) {
                width += arrayWidth(((PHPDataArray) phpDataType).getValue());
            } else width++;
        }
        return width;
    }

    public String[][] getExportDataArray() throws PHPDataModelException {
        String[][] dataArray = new String[arrayDepth()][arrayWidth()];
        CurrentPosition cp = new CurrentPosition();
        cp.col = 0;
        cp.row = 0;
        getExportDataArray(dataArray, cp, getPhpDataElementList());
        return dataArray;
    }

    private void getExportDataArray(String[][] dataArray, CurrentPosition cp, List<PHPDataElement> phpDataElementList) throws PHPDataModelException {
        for (PHPDataElement phpDataElement : phpDataElementList) {
            dataArray[cp.row][cp.col] = phpDataElement.getPHPElementName().getName();
            PHPDataType phpDataType = phpDataElement.getValue();
            if ((phpDataType instanceof PHPDataArray)) {
                cp.row++;
                getExportDataArray(dataArray, cp, ((PHPDataArray) phpDataType).getValue());
                cp.row--;
            } else {
                dataArray[dataArray.length - 1][cp.col] = phpDataElement.getValue().toString();
                cp.col++;
            }

        }
    }

    static class CurrentPosition {
        int row;
        int col;
    }
}
