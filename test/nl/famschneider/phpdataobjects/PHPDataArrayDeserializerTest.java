package nl.famschneider.phpdataobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class PHPDataArrayDeserializerTest {

    @Test
    void testString() {
        assertEquals("s:4:\"root\";a:1:{s:6:\"STRING\";s:6:\"string\";};", new PHPDataDeSerializer(
                "a:1:{s:6:\"STRING\";s:6:\"string\";};"
        ).getPhpDataStructure().toString());
    }
    @Test
    void testBoolean() {
        assertEquals("s:4:\"root\";a:1:{s:7:\"BOOLEAN\";b:0;};", new PHPDataDeSerializer(
                "a:1:{s:7:\"BOOLEAN\";b:0;};"
        ).getPhpDataStructure().toString());
    }
    @Test
    void testInteger() {
        assertEquals("s:4:\"root\";a:1:{s:7:\"INTEGER\";i:66;};", new PHPDataDeSerializer(
                "a:1:{s:7:\"INTEGER\";i:66;};"
        ).getPhpDataStructure().toString());
    }
    @Test
    void testDouble() {
        assertEquals("s:4:\"root\";a:1:{s:6:\"DOUBLE\";d:66.66;};", new PHPDataDeSerializer(
                "a:1:{s:6:\"DOUBLE\";d:66.66;};"
        ).getPhpDataStructure().toString());
    }
    @Test
    void testNull() {
        assertEquals("s:4:\"root\";a:1:{s:4:\"NULL\";N;};", new PHPDataDeSerializer(
                "a:1:{s:4:\"NULL\";N}"
        ).getPhpDataStructure().toString());
    }
    @Test
    void testBig(){
        String PHPTestArray = "a:11:{" +
                "s:16:\"from_email_field\";s:22:\"info@presentalkmaar.nl\";" +
                "s:7:\"Integer\";i:55246;" +
                "s:6:\"Double\";d:55.246;" +
                "s:4:\"Null\";N;" +
                "s:15:\"from_name_field\";s:17:\"Present\" Alkmaar\"\";" +
                "s:13:\"smtp_settings\";a:8:{" +
                "s:4:\"host\";s:14:\"presentmail.nl\";" +
                "s:15:\"type_encryption\";s:3:\"tls\";" +
                "s:4:\"port\";s:3:\"587\";" +
                "s:13:\"autentication\";s:3:\"yes\";" +
                "s:8:\"username\";s:22:\"smtp@presentalkmaar.nl\";" +
                "s:8:\"password\";s:16:\"alpANTMtMTItMTg=\";" +
                "s:6:\"secret\";a:2:{" +
                "s:12:\"enable_debug\";b:1;" +
                "s:12:\"insecure_ssl\";b:0;};" +
                "s:12:\"encrypt_pass\";b:0;};" +
                "s:23:\"force_from_name_replace\";b:0;" +
                "s:14:\"reply_to_email\";s:0:\"\";" +
                "s:17:\"email_ignore_list\";s:0:\"\";" +
                "s:19:\"enable_domain_check\";b:0;" +
                "s:15:\"allowed_domains\";s:0:\"\";" +
                "};";
        assertEquals("s:4:\"root\";"+ PHPTestArray, new PHPDataDeSerializer(
                PHPTestArray
        ).getPhpDataStructure().toString());
    }
}