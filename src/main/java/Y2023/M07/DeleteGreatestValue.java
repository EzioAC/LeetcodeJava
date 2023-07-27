package Y2023.M07;

import java.util.Arrays;

public class DeleteGreatestValue {
	public int deleteGreatestValue(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			Arrays.sort(grid[i]);
		}
		int res = 0;
		for (int j = 0; j < n; j++) {
			int mx = 0;
			for (int i = 0; i < m; i++) {
				mx = Math.max(mx, grid[i][j]);
			}
			res += mx;
		}
		return res;
	}
}
