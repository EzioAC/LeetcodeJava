package Y2023.M07;

import org.junit.jupiter.api.Test;

public class Trap {
	public int trap(int[] height) {
		int res = 0;
		int[] rightMax = new int[height.length];
		rightMax[height.length-1] = height[height.length-1];
		for (int i = height.length-2; i >= 0 ; i--) {
			rightMax[i] = Math.max(rightMax[i+1],height[i]);
		}
		int[] leftMax = new int[height.length];
		leftMax[0] = height[0];
		for (int i = 1; i < height.length ; i++) {
			leftMax[i] = Math.max(leftMax[i-1],height[i]);
		}

		for (int i = 1; i < height.length-1 ; i++) {
			res += Math.min(leftMax[i],rightMax[i]) - height[i];
		}

		return res;
	}

	@Test
	public void test() {
		Trap trap = new Trap();
		System.out.println(trap.trap(new int[]{4,3,2,1,3,5}));

	}
}
