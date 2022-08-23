package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		Test t = new Test();
		int[] ret = t.twoSum(nums, target);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}

	
	public int[] twoSum(int[] nums, int target) {
		// 1.定义返回
		int[] retIndex = new int[2];
		// 2.防御式编程，检查参数
		if (nums == null || nums.length == 0) {
			return retIndex;
		}
		
		// 3.处理逻辑
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				retIndex[1] = i;
				retIndex[0] = map.get(temp);
			}
			map.put(nums[i], i);
		}
		
		// 4.返回返回值
		return retIndex;
	}
}