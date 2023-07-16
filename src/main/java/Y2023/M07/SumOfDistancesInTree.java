package Y2023.M07;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SumOfDistancesInTree {

    /**
     * 递归的原因，放在公共变量里面
     */
    //结果
    int[] res;
    //节点树
    int[] nodeNum;
    //节点数
    int n;
    //树
    List<Integer>[] tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        nodeNum = new int[n];
        this.n = n;
        res = new int[n];

        //构建树
        tree = new List[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int l = edges[i][0];
            int r = edges[i][1];
            tree[l].add(r);
            tree[r].add(l);
        }

        //计算res[0]
        //计算nodeNum
        initHelper(-1,0,0);
        //计算res[1...n-1]
        resHelper(-1,0);
        return res;
    }

    public int initHelper(int parent, int curr, int distance) {
        res[0] += distance;
        int res = 1;
        for (int i = 0; i < tree[curr].size(); i++) {
            int next = tree[curr].get(i);
            if(next == parent) {
                continue;
            }
            res += initHelper(curr,next,distance+1);
        }
        nodeNum[curr] = res;
        return  nodeNum[curr];
    }

    public void resHelper(int parent, int curr) {
        if(curr != 0) {
            res[curr] = res[parent] + n - 2* nodeNum[curr];
        }

        for (Integer next : tree[curr]) {
            if(next == parent) {
                continue;
            }
            resHelper(curr, next);
        }
    }

    public static void main(String[] args) {
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();
        System.out.println(JSON.toJSONString(sumOfDistancesInTree.sumOfDistancesInTree(6,new int[][]{
                new int[]{0,1},
                new int[]{0,2},
                new int[]{2,3},
                new int[]{2,4},
                new int[]{2,5}
        })));

        System.out.println(JSON.toJSONString(sumOfDistancesInTree.sumOfDistancesInTree(1,new int[][]{
        })));

        System.out.println(JSON.toJSONString(sumOfDistancesInTree.sumOfDistancesInTree(2,new int[][]{
                new int[]{1,0}
        })));

        System.out.println(JSON.toJSONString(sumOfDistancesInTree.sumOfDistancesInTree(3,new int[][]{
                new int[]{2,1},
                new int[]{0,2},
        })));
    }



}
