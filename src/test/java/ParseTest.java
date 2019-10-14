import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ParseTest {

    @Test
    public void runSimpleTest() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

}
