package Y2023.M07;

public class MaxSubarraySumCircular {
	public int maxSubarraySumCircular(int[] nums) {
		int[] leftMax = new int[nums.length];
		leftMax[0] = nums[0];
		int res = leftMax[0];
		int preMax = nums[0];
		int leftSum = nums[0];
		for (int i = 1; i < leftMax.length ; i++) {
			preMax = Math.max(preMax+nums[i],nums[i]);
			res = Math.max(res,preMax);
			leftSum += nums[i];
			leftMax[i] = Math.max(leftMax[i-1] ,leftSum);
		}


		int rightSum = nums[nums.length-1];
		for (int i = nums.length-2; i >= 0; i--) {
			res = Math.max(res,leftMax[i]+rightSum);
			rightSum += nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
		System.out.println(
				maxSubarraySumCircular.maxSubarraySumCircular(new int[]{1,-2,3,-2})
		);
		System.out.println(
				maxSubarraySumCircular.maxSubarraySumCircular(new int[]{5,-3,5})
		);
		System.out.println(
				maxSubarraySumCircular.maxSubarraySumCircular(new int[]{3,-2,2,-3})
		);

	}
}
