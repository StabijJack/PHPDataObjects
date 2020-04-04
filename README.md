<h1>PHPDataObjects</h1>

<p>DeSerialize PHPSerialized data to java Objects</p>
<h2>Constructor accepts Strings formatted as</h2>

<ol>
    <li>Serialized Array definition on <a href="https://www.php.net/manual/en/function.serialize">site</a> </li>
    <li>Serialized structure example: {"name"= "value","name"={"name"="value,"name"="value"}} </li>
</ol>
<h2>Available methods</h2>
<ul>
    <li>getoption.. methods correct object or throws error for existing options and for wrong object type</li>
    <li>isOption... returns true or false</li>
    <li>getOptionsNames.... return filled - or empty set</li>
    <li>exportFieldMapToExcelCSVFile accepts String FileName</li>
</ul>


<h2>Serialized Array definition</h2>
<p> starts with a:</p>

<h4> Not implemented:</h4>
<ul>
    <li>Test Object with properties:<br>
        O:4:"Test":3:{s:6:"public";i:1;s:12:"\0*\0protected";i:2;s:13:"\0Test\0private";i:3;}
    </li>
    <li>
        Test2 Object with his own serialization method <br>
        C:5:"Test2":6:{foobar}
    </li>
    <li>internal reference <br>
         a:2:{i:0;s:3:"foo";i:1;R:2;}
    </li>
    <li>internal reference <br>
         O:8:"stdClass":1:{s:3:"foo";r:1;}
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
