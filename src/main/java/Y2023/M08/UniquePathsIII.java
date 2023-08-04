package Y2023.M08;

import org.junit.jupiter.api.Test;

public class UniquePathsIII {

	static int yLen,xLen;
	static int xStart;
	static int yStart;
	static int xEnd;
	static int yEnd;
	static int pathLen;

	static Integer res = 0;
	static int[][] directions = new int[][] {
			new int[] {0,1},
			new int[] {1,0},
			new int[] {0,-1},
			new int[] {-1,0}
	};
	public int uniquePathsIII(int[][] grid) {
		res = 0;
		yLen = grid.length;
		xLen = grid[0].length;
		pathLen = yLen * xLen -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					xStart = j;
					yStart = i;
				} else if(grid[i][j] == 2) {
					xEnd = j;
					yEnd = i;
				} else if(grid[i][j] == -1) {
					pathLen--;
				}
			}
		}
		dfs(yStart,xStart,grid,pathLen);
		return res;
	}

	public static void dfs(int y,int x,int[][] grid,int leftPathLen) {
		if(x < 0 || y<0 || x>= xLen || y>=yLen) {
			return;
		}
		if(y == yEnd && x == xEnd ) {
			if(leftPathLen == 0) {
				res++;
			}
			return;
		}
		if(leftPathLen == 0 || grid[y][x] == -1) {
			return;
		}
		grid[y][x] = -1;
		for (int[] direction : directions) {
			dfs(y+direction[0],x+direction[1],grid,leftPathLen-1);
		}
		grid[y][x] = 0;
	}

	@Test
	public void test() {
		UniquePathsIII uniquePathsIII = new UniquePathsIII();
		System.out.println(uniquePathsIII.uniquePathsIII(new int[][]{
				new int[] {1,0,0,0},
				new int[] {0,0,0,0},
				new int[] {0,0,2,-1},
		}));

		System.out.println(uniquePathsIII.uniquePathsIII(new int[][]{
				new int[] {1,0,0,0},
				new int[] {0,0,0,0},
				new int[] {0,0,0,2},
		}));

		System.out.println(uniquePathsIII.uniquePathsIII(new int[][]{
				new int[] {0,1},
				new int[] {2,0}
		}));
	}
}
