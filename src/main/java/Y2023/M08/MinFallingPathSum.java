package Y2023.M08;

import org.junit.jupiter.api.Test;

public class MinFallingPathSum {
	public int minFallingPathSum(int[][] grid) {
		int firstMinSum = 0;
		int secMinSum = 0;
		int firstMinSumIndex = -1;
		for (int i = 0; i < grid.length; i++) {
			int currFirstMinSum = Integer.MAX_VALUE;
			int currSecMinSum = Integer.MAX_VALUE;
			int currFirstMinSumIndex = -1;
			for (int j = 0; j < grid[i].length; j++) {
				int currSum = (firstMinSumIndex == j ? secMinSum : firstMinSum) + grid[i][j];
				if(currSum < currFirstMinSum) {
					currSecMinSum = currFirstMinSum;
					currFirstMinSum = currSum;
					currFirstMinSumIndex = j;
				} else if (currSum <currSecMinSum) {
					currSecMinSum = currSum;
				}
			}
			firstMinSum = currFirstMinSum;
			secMinSum = currSecMinSum;
			firstMinSumIndex = currFirstMinSumIndex;
		}
		return firstMinSum;
	}

	@Test
	public void test() {
		MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
		minFallingPathSum.minFallingPathSum(new int[][]{
				new int[]{1,2,3},
				new int[]{4,5,6},
				new int[]{7,8,9}
		});
	}


}
