package Y2023.M08;

import org.junit.jupiter.api.Test;

public class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int tail = nums1.length - 1;
		int tail1 = m-1;
		int tail2 = n-1;
		while (tail1 >=0 && tail2 >=0) {
			if(nums1[tail1] > nums2[tail2]) {
				nums1[tail--] = nums1[tail1--];
			} else {
				nums1[tail--] = nums2[tail2--];
			}
		}
		while(tail2 >= 0) {
			nums1[tail--] = nums2[tail2--];
		}
	}

	@Test
	public void test() {
		Merge merge = new Merge();
		merge.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
	}

	@Test
	public void test2() {
		Merge merge = new Merge();
		merge.merge(new int[]{1},13,new int[]{},0);
	}

	@Test
	public void test3() {
		Merge merge = new Merge();
		merge.merge(new int[]{},0,new int[]{},0);
	}

}
