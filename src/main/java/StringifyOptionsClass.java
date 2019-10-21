import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StringifyOptionsClass {
    private boolean addQueryPrefix;
    private boolean allowDots;
    private boolean charsetSentinel;
    private boolean encode;
    private boolean encodeValuesOnly;
    private String charset;
    private String delimiter;
}
