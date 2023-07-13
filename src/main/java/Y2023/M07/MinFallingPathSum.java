package Y2023.M07;

import common.InputConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[0][i] = matrix[0][i];
        }
        for(int y=1;y<n;y++) {
            for(int x=0;x<n;x++) {
                dp[y][x] = Integer.MAX_VALUE;
                for(int offset = -1;offset<2;offset++) {
                    int lastX = offset + x;
                    if(lastX < 0 || lastX >=n ) {
                        continue;
                    }
                    dp[y][x] = Math.min(dp[y][x],dp[y-1][lastX] + matrix[y][x]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            res = Math.min(res,dp[n-1][x]);
        }
        return res;
    }

    @Test
    public void test() {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        Assertions.assertEquals(
            minFallingPathSum.minFallingPathSum(InputConverter.to("[[2,1,3],[6,5,4],[7,8,9]]")),13
        );
        Assertions.assertEquals(
                minFallingPathSum.minFallingPathSum(InputConverter.to("[[-19,57],[-40,-5]]")),-59
        );
    }

}
