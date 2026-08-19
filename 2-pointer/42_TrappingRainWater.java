/**
 * Problem Link : https://leetcode.com/problems/trapping-rain-water/
 * Platform     : LeetCode
 * Difficulty   : Hard
 */

class Solution {
    public int trap(int[] height) {
        int ans = 0,width=1;
        int l=0,r=height.length-1;
        int lmax=0,rmax=0;
        while(l<r){
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            if(lmax < rmax){
                ans += (lmax-height[l])*width;
                l++;
            }
            else{
                ans += (rmax-height[r])*width;
                r--;
            }
        }
        return ans;
    }
}

