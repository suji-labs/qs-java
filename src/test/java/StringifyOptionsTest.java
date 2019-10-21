import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringifyOptionsTest {

    private StringifyOptionsClass stringifyOptionsClass;

    @Before
    public void setUp() {
        stringifyOptionsClass = new StringifyOptionsClass();
    }

    @Test
    public void testSetter() {
        String result = "StringifyOptionsClass(addQueryPrefix=false, allowDots=false, charsetSentinel=false, encode=false, encodeValuesOnly=false, charset=null, delimiter=null)";
        String toString = stringifyOptionsClass.toString();
        assertEquals("should be equals", result, toString);
    }
}

