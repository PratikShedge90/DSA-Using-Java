class Solution {
    public int removeDuplicates(int[] nums) {
    
    if(nums.length==1)
		return 1;

    int prev=0;
    for(int i=1; i<nums.length; i++)
    {
        if(nums[prev] == nums[i])
        {
            continue;
        }
        else
        {
            prev++;
            nums[prev] = nums[i];
        }
    }
    return prev+1;
    }
}
