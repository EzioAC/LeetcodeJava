package Y2023.M07;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaxValueOfEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
		//res = yj+yi+xj-xi
		int res = Integer.MIN_VALUE;
		Deque<int[]> queue = new ArrayDeque<int[]>();
		for (int[] point : points) {
			int y = point[1];
			int x = point[0];
			//保证xj-xi<k
			while(!queue.isEmpty() && x - queue.getFirst()[1] > k) {
				queue.removeFirst();
			}

			if(!queue.isEmpty()) {
				res = Math.max(res,queue.getFirst()[0]+x+y);
			}
			//保证y-x是单点递减的
			while(!queue.isEmpty() && y - x > queue.getLast()[0]){
				queue.removeLast();
			}
			//xj-xi,xi
			queue.addLast(new int[]{ y - x,x});
		}
		return res;
	}
}
