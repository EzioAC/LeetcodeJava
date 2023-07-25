package Y2023.M07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HalveArray {
	public int halveArray(int[] nums) {
		double sum = 0;
		PriorityQueue<Double> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
			maxQueue.add((double) nums[i]);
		}
		double target = sum/2;
		double sum2 = 0;
		int res = 0;
		while(sum2 < target) {
			double poll = maxQueue.poll().doubleValue();
			sum2 += poll/2;
			maxQueue.add(poll/2);
			res++;
		}
		return res;
	}
}
