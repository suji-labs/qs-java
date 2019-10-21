public class Formats {
    public final static String PERCENT_TWENTIES = "%20";

    public static String format(Format format, String value) {
        if (format == Format.RFC1738)
            return value.replaceAll(PERCENT_TWENTIES, "+" );
        else if (format == Format.RFC3986){
            return value;
        } else {
            throw new IllegalArgumentException("Invalid Format.");
        }
    }
}
