package Y2023.M07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandleQuery {

	@Test
	public void test() {
		HandleQuery handleQuery = new HandleQuery();
		System.out.println(Arrays.toString(
			handleQuery.handleQuery(
					new int[]{1,0,1},
					new int[]{0,0,0},
					new int[][] {
							new int[]{1,1,1},
							new int[]{2,1,0},
							new int[]{3,0,0}
					}
			)
		));

		System.out.println(Arrays.toString(
				handleQuery.handleQuery(
						new int[]{1},
						new int[]{5},
						new int[][] {
								new int[]{2,0,0},
								new int[]{3,0,0}
						}
				)
		));
	}
	public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
		int n = nums1.length;
		int m = queries.length;
		SegTree tree = new SegTree(nums1);

		long sum = 0;
		for (int num : nums2) {
			sum += num;
		}
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < m; i++) {
			if (queries[i][0] == 1) {
				int l = queries[i][1];
				int r = queries[i][2];
				tree.reverse(l, r);
			} else if (queries[i][0] == 2) {
				sum += (long) tree.sum(0, n - 1) * queries[i][1];
			} else if (queries[i][0] == 3) {
				list.add(sum);
			}
		}
		long[] ans = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}
}

class SegTree {
	SegNode[] nodes;

	public SegTree(int[] nums) {
		int n = nums.length;
		nodes = new SegNode[4*n+1];
		build(1,0,n-1,nums);

	}

	private void build(int id,int l,int r,int[] nums) {
		SegNode segNode = new SegNode();
		segNode.l = l;
		segNode.r = r;
		segNode.lazyFlag = false;
		nodes[id] = segNode;
		if(l==r) {
			segNode.sum = nums[l];
			return;
		}
		build(id*2,l,(l+r)/2,nums);
		build(id*2+1,(l+r)/2+1,r,nums);
		segNode.sum = nodes[id*2].sum + nodes[id*2+1].sum;
	}

	public void reverse(int l,int r) {
		reverse(1,l,r);
	}

	private void reverse(int id,int l,int r) {
		SegNode segNode = nodes[id];
		if(segNode.l > r || segNode.r < l) {
			return;
		}
		//完全在范围里面,全量翻转
		if(segNode.l >= l &&segNode.r <= r) {
			segNode.sum = segNode.r - segNode.l + 1 - segNode.sum;
			segNode.lazyFlag = !segNode.lazyFlag;
			return;
		}
		pushdown(id);
		reverse(id*2,l,r);
		reverse(id*2+1,l,r);
		nodes[id].sum = nodes[id*2].sum + nodes[id*2+1].sum;
	}

	public int sum(int l,int r) {
		return sum(1,l,r);
	}

	private int sum(int id, int l,int r) {
		SegNode segNode = nodes[id];
		if (segNode.l >= l && segNode.r <= r) {
			return segNode.sum;
		}
		if(segNode.l > r || segNode.r > l) {
			return 0;
		}
		pushdown(id);
		int res = 0;
		if (nodes[2 * id].r >= l) {
			res += sum(2 * id, l, r);
		}
		if (nodes[2 * id + 1].l <= r) {
			res += sum(2 * id + 1, l, r);
		}
		return res;
	}

	public void pushdown(int x) {
		if(nodes[x].lazyFlag) {
			nodes[2 * x].lazyFlag = !nodes[2 * x].lazyFlag;
			nodes[2 * x].sum = nodes[2 * x].r - nodes[2 * x].l + 1 - nodes[2 * x].sum;
			nodes[2 * x + 1].lazyFlag = !nodes[2 * x + 1].lazyFlag;
			nodes[2 * x + 1].sum = nodes[2 * x + 1].r - nodes[2 * x + 1].l + 1 - nodes[2 * x + 1].sum;
			nodes[x].lazyFlag = false;
		}
	}



}

class SegNode {
	int l,r,sum;
	boolean lazyFlag;
}

