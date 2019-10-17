import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void testCombine() {
        Utils utils = new Utils();

        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> combined = new ArrayList<Integer>();

        a.add(1);
        b.add(2);
        combined.add(1);
        combined.add(2);

        assertEquals("both arrays", combined, utils.combine(a, b));
        assertEquals("one array, one non-array", combined, utils.combine(a, 2));
        assertEquals("one non-array, one array", combined, utils.combine(1,  b));
        assertEquals("neither is an array", combined, utils.combine(1,  2));
    }

    @Test
    public void testArrayToObject() {
        Utils utils = new Utils();

        List<String> a = new ArrayList<>();
        Map<Integer, String> transformed = new HashMap<>();

        a.add("a");
        a.add("b");

        transformed.put(0, "a");
        transformed.put(1, "b");

        assertEquals("both Strings", transformed, utils.arrayToObject(a));
    }
}
