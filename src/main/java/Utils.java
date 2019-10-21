import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Utils {
    public static <T> Map<Integer, T> arrayToObject(List<T> a) {
        Map<Integer, T> result = new HashMap<>();

        for (int i = 0, len = a.size(); i < len; i++) {
            result.put(i, a.get(i));
        }

        return result;
    }

    public static <T> List<T> combine(T a, T b) {
        List<T> result = new ArrayList<T>();

        result.add(a);
        result.add(b);

        return result;
    }

    public static <T> List<T> combine(List<T> a, T b) {
        List<T> result = new ArrayList<T>();

        result.addAll(a);
        result.add(b);

        return result;
    }

    public static <T> List<T> combine(T a, List<T> b) {
        List<T> result = new ArrayList<T>();

        result.add(a);
        result.addAll(b);

        return result;
    }

    public static <T> List<T> combine(List<T> a, List<T> b) {
        List<T> result = new ArrayList<T>();

        result.addAll(a);
        result.addAll(b);

        return result;
    }

    public static <K, V>Map<K, V> assign(Map<K, V> target, Map<K, V> source) {
        target.putAll(source);
        return target;
    }

    public static String decode(String str, String charset) {
        String strWithoutPlus = str.replaceAll("\\+", " ");
        if (charset.toLowerCase().equals("iso-8859-1")) {
            try {
                return URLDecoder.decode(strWithoutPlus, "iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                return strWithoutPlus;
            }
        }
        // return UTF-8
        try {
            return URLDecoder.decode(strWithoutPlus, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return strWithoutPlus;
        }
    }

    // Overloading for default parameter
    public static String decode(String str) {
        return decode(str, "utf-8");
    }
}
