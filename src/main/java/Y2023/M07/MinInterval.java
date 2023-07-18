package Y2023.M07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinInterval {

	public int[] minInterval(int[][] intervals, int[] queries) {
		Integer[] qIndex = new Integer[queries.length];
		for (int i = 0; i < qIndex.length; i++) {
			qIndex[i] = i;
		}
		Arrays.sort(qIndex, Comparator.comparingInt(x -> queries[x]));
		Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
		//<长度，有边界>
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int[] res = new int[queries.length];
		Arrays.fill(res, -1);
		int i = 0;
		for (int qi : qIndex) {
			//左边界在右边
			while (i < intervals.length && intervals[i][0] <= queries[qi]) {
				priorityQueue.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
				i++;
			}
			while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] < queries[qi]) {
				//右边界在左边
				priorityQueue.poll();
			}
			if (!priorityQueue.isEmpty()) {
				//长度最小的值
				res[qi] = priorityQueue.peek()[0];
			}
		}
		return res;
	}

}
