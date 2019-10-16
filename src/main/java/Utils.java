import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static <T> List<T> combine(T a, T b) {
        List<T> result = new ArrayList<>();

        result.add(a);
        result.add(b);

        return result;
    }

    public static <T> List<T> combine(List<T> a, T b) {
        List<T> result = new ArrayList<>();

        result.addAll(a);
        result.add(b);

        return result;
    }

    public static <T> List<T> combine(T a, List<T> b) {
        List<T> result = new ArrayList<>();

        result.add(a);
        result.addAll(b);

        return result;
    }

    public static <T> List<T> combine(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>();

        result.addAll(a);
        result.addAll(b);

        return result;
    }
}
