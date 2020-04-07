<h1>PHPDataObjects</h1>

<p>DeSerialize PHPSerialized data to java Objects</p>
<h2>Constructor accepts Strings formatted as</h2>

<ol>
    <li>Serialized Array definition on <a href="https://www.php.net/manual/en/function.serialize">site</a> </li>
    <li>Serialized structure example: {"name"= "value","name"={"name"="value,"name"="value"}} </li>
</ol>
<p>The constructor of this package is PHPDataDeSerializer it accepts the serialized String of the PHP function serialize. <br>
PHPDateDeSerializer(String string) returns a PHPDataStructure object</p>
<h2>Available retrieval methods</h2>
<ul>
    <li>getExportDataArray() returns a String[][] with 
        <ul>
            <li>field names in the top n rows (header)</li>
            <li>field values in the last row.</li>
        </ul>
    </li>
    <li>getExportDataArrayHeader()</li>
    <li>getExportDataArrayValues()</li>
    <li> getSerializeFormat() returns the Format of the serialized input</li>
    <li>serializeToFormat(Format) returns a serialized String of the PHPDataStructure</li>
</ul>
<h2>You can build a PHPDataStructure without using a DeSerializer</h2>
<p>
The PHPDataStructure contains a list of PHPDataElement's.<br>
A PHPDataElement contains a name PHPDataElementName and a value PHPDataType.<br>
A name PHPDataElementName contains a PHPDataString or a PHPDataInteger.<br>
A value is a any Class that extends PHPDataType.
</p>

<h2>Serialized Array definition</h2>
<p> starts with a:</p>

<h4> Not implemented:</h4>
<ul>
    <li>Test Object with properties:<br>
        <strong>O</strong>:4:"Test":3:{s:6:"public";i:1;s:12:"\0*\0protected";i:2;s:13:"\0Test\0private";i:3;}
    </li>
    <li>
        Test2 Object with his own serialization method <br>
        <strong>C</strong>:5:"Test2":6:{foobar}
    </li>
    <li>internal reference <br>
         a:2:{i:0;s:3:"foo";i:1;<strong>R</strong>:2;}
    </li>
    <li>internal reference <br>
         O:8:"stdClass":1:{s:3:"foo";<strong>r</strong>:1;}
    </li>
</ul>


<h2>Serialized structure</h2>
<p>example: {"name"= "value","name"={"name"="value,"name"="value"}}</p>


<p> structure: {nameValuePair, .....}</p>

<p>nameValuePair is "name"= value</p>

<p>value is </p>
<ol>
    <li>structure {...} </li>
    <li>String "..." <br>\" between "" represents a "</li>    
    <li>Null</li>
    <li>true</li>
    <li>false</li>
    <li>any sequence of characters until the next , or }</li>
</ol>
