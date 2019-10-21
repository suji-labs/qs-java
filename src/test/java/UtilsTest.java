import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.hamcrest.collection.IsMapContaining;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Map<String, Integer> target = new HashMap<>();
        target.put("a", 1);
        target.put("b", 2);

        Map<String, Integer> source = new HashMap<>();
        source.put("b", 3);
        source.put("c", 4);

        Map<String, Integer> result = utils.assign(target, source);

        assertThat(source.size(), is(2)); // source is untouched
        assertThat(source, IsMapContaining.hasEntry("b", 3));
        assertThat(source, IsMapContaining.hasEntry("c", 4));

        assertThat(result, is(target));         // returns the target
        assertThat(result.size(), is(3)); // should be { a: 1, b: 3, c: 4 }
        assertThat(result, IsMapContaining.hasEntry("a", 1));
        assertThat(result, IsMapContaining.hasEntry("b", 3));
        assertThat(result, IsMapContaining.hasEntry("c", 4));
    }

    @Test
    public void testDecode() {
        String url = "https%3A%2F%2Fr1---sn-ci5gup-cags.googlevideo.com%2Fvideoplayback%3Fpcm2cms%3Dyes%26mime%3Dvideo%252Fmp4%26pl%3D21%26itag%3D22%26\u0026itag=43\u0026type=video%2Fwebm%3B+codecs%3D%22vp8.0%2C+vorbis%22\u0026quality=medium";
        String decodedURL = "https://r1---sn-ci5gup-cags.googlevideo.com/videoplayback?pcm2cms=yes&mime=video%2Fmp4&pl=21&itag=22&&itag=43&type=video/webm; codecs=\"vp8.0, vorbis\"&quality=medium";
        assertThat(utils.decode(url), is(decodedURL));

        String url2 = "https://onlineutf8tools.com/validate-utf8?input=Not%20all%20text%20is%20created%20equal.%20Some%20is%20missing%20bytes.%20ðŸŒ";
        String decodedURL2 = "https://onlineutf8tools.com/validate-utf8?input=Not all text is created equal. Some is missing bytes. ðŸŒ";
        assertThat(utils.decode(url2, "iso-8859-1"), is(decodedURL2));
    }
}
