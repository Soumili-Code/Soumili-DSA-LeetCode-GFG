class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int sum=0;
        int minLen = Integer.MAX_VALUE;
        while(r<nums.length){
            sum+=nums[r];
            while(l<=r && sum>=target){
                int len = r-l+1;
                minLen=Math.min(minLen,len);
                sum-=nums[l];
                l++;
            }
            r++;
        }
       if(minLen == Integer.MAX_VALUE)
        return 0;
        else return minLen;
    }
}