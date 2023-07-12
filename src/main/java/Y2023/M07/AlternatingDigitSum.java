package Y2023.M07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int res = 0;
        int isPositive = -1;
        while(n > 0) {
            isPositive *= -1;
            res += isPositive*n%10;
            n = n/10;
        }
        return res * isPositive;
    }

    @Test
    public void test() {
        AlternatingDigitSum alternatingDigitSum = new AlternatingDigitSum();
        Assertions.assertEquals(
                alternatingDigitSum.alternateDigitSum(521),4
        );
        Assertions.assertEquals(
                alternatingDigitSum.alternateDigitSum(10),1
        );
        Assertions.assertEquals(
                alternatingDigitSum.alternateDigitSum(111),1
        );
        Assertions.assertEquals(
                alternatingDigitSum.alternateDigitSum(1111),0
        );
        Assertions.assertEquals(
                alternatingDigitSum.alternateDigitSum(886996),0
        );

    }
}
