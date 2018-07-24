
public boolean groupSum(int start, int[] nums, int target) {


return start>= nums.length ? target==0: groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target); 


}
