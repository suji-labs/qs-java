import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
