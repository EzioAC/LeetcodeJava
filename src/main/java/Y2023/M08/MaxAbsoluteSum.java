package Y2023.M08;

import org.junit.jupiter.api.Test;

public class MaxAbsoluteSum {
	public int maxAbsoluteSum(int[] nums) {
		int res = 0;
		int min = 0;
		int max = 0;

		for (int num : nums) {
			min = Math.min(0,min + num);
			max = Math.max(0,max + num);
			res = Math.max(res,max);
			res = Math.max(res,-min);
		}
		return res;
	}

	@Test
	public void test() {
		MaxAbsoluteSum maxAbsoluteSum =new MaxAbsoluteSum();
		System.out.println(
			maxAbsoluteSum.maxAbsoluteSum(new int[]{1,-3,2,3,-4})
		);
		System.out.println(
			maxAbsoluteSum.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2})
		);
	}
}
