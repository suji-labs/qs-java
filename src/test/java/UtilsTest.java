import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    private Utils utils;

    @Before
    public void setUp() {
        utils = new Utils();
    }

    @Test
    public void testCombine() {
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

    public void testAssign() {
        Map<String, Integer> target = new HashMap<String, Integer>();
        target.put("a", 1);
        target.put("b", 2);

        Map<String, Integer> source = new HashMap<String, Integer>();
        source.put("b", 3);
        source.put("c", 4);

        Map<String, Integer> result = utils.assign(target, source);

        assertEquals("returns the target", result, target);
    }
}
