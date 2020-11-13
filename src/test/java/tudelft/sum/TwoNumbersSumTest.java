package tudelft.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.countletters.CountLetters;
import tudelft.roman.RomanNumeral;

public class TwoNumbersSumTest
{
    TwoNumbersSum twoNumbersSum;

    @BeforeEach
    public void initialize() {
        twoNumbersSum = new TwoNumbersSum();
    }

    @ParameterizedTest(name = "one={0}, two={1}, expectedResult={2}")
    @CsvSource({ "-1,-1,-1", "-1,1,1" })
    public void emptyListTest(int one, int two, int expectedResult)
    {
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(encodeList(one), encodeList(two));
        Assertions.assertEquals(expectedResult, decodeList(result));
    }

    @ParameterizedTest(name = "one={0}, two={1}, expectedResult={2}")
    @CsvSource({ "123,321,444", "12,45,57" })
    public void sameLengthTest(int one, int two, int expectedResult)
    {
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(encodeList(one), encodeList(two));
        Assertions.assertEquals(expectedResult, decodeList(result));
    }

    @ParameterizedTest(name = "one={0}, two={1}, expectedResult={2}")
    @CsvSource({ "125,327,452", "19,45,64", "15,638,653" })
    public void carry1Test(int one, int two, int expectedResult)
    {
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(encodeList(one), encodeList(two));
        Assertions.assertEquals(expectedResult, decodeList(result));
    }

    @ParameterizedTest(name = "one={0}, two={1}, expectedResult={2}")
    @CsvSource({ "145,79,224", "79,145,224" })
    public void carryDifferentLengthTest(int one, int two, int expectedResult)
    {
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(encodeList(one), encodeList(two));
        Assertions.assertEquals(expectedResult, decodeList(result));
    }

    @ParameterizedTest(name = "one={0}, two={1}, expectedResult={2}")
    @CsvSource({ "912,333,1245" })
    public void carryLeftTest(int one, int two, int expectedResult)
    {
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(encodeList(one), encodeList(two));
        Assertions.assertEquals(expectedResult, decodeList(result));
    }

    private ArrayList<Integer> encodeList(int i)
    {
        if (i < 0)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        do
        {
            result.add(i % 10);
            i /= 10;
        }
        while (i > 0);
        Collections.reverse(result);
        return result;
    }

    private int decodeList(ArrayList<Integer> list)
    {
        if (list.size() == 0)
            return -1;
        int result = 0;
        int multiplier = 1;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            result += list.get(i) * multiplier;
            multiplier *= 10;
        }
        return result;
    }
}
