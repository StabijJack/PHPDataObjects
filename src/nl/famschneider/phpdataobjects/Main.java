package nl.famschneider.phpdataobjects;

import nl.famschneider.phpdataobjects.datamodel.PHPDataStructure;

public class Main {
    public static void main(String[] args) {

        PHPDataStructure phpDataStructure = new PHPDataDeSerializer(args[0]).getPhpDataStructure();

    }
}
