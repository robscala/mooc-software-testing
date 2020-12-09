package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {

    @ParameterizedTest(name = "in={0}, expectedResult={1}")
    @CsvSource({ "abcba,abcba", "abba,abba", "abcdba,ab", "a,a", "ab,''", "abcd,''" })
    public void basicTest(String in, String expectedResult) {
        Mirror mirror = new Mirror();
        String result = mirror.mirrorEnds(in);
        Assertions.assertEquals(expectedResult, result);
    }

}
