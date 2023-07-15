package Y2023.M07;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for(int num1 = 0 ; num1 < nums.length - 3 ;  num1++)
        {
            //去重
            if(num1 > 0 && nums[num1] == nums[num1-1]) {
                continue;
            }
            for(int num2 = num1+1;num2<nums.length - 2; num2 ++) {
                //去重
                if(num2 > num1+1 && nums[num2] == nums[num2-1]) {
                    continue;
                }
                int num3 = num2 + 1;
                int num4 = nums.length - 1;
                //避免数据溢出
                long currentTarget = 0L + target - nums[num1] - nums[num2];
                while(num3 < num4) {
                    //去重
                    if(num3 > num2+1 && nums[num3] == nums[num3-1]) {
                        num3++;
                        continue;
                    }
                    //剪枝
                    if(currentTarget > nums[num4-1] + nums[num4]) {
                        break;
                    }
                    if(currentTarget < nums[num3] + nums[num3+1]) {
                        break;
                    }
                    //双指针挪动
                    if(currentTarget == nums[num3] + nums[num4]) {
                        res.add(List.of(nums[num1], nums[num2], nums[num3], nums[num4]));
                        num3++;
                        num4--;
                    } else if(currentTarget > nums[num3] + nums[num4]) {
                        num3++;
                    } else {
                        num4--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        //去重验证
        System.out.println(JSON.toJSONString(fourSum.fourSum(new int[]{2,2,2,2,2,2},8)));
        //数据溢出验证
        System.out.println(JSON.toJSONString(fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296 )));
        //普通验证
        System.out.println(JSON.toJSONString(fourSum.fourSum(new int[]{1,0,-1,0,-2,2},0 )));
    }
}
