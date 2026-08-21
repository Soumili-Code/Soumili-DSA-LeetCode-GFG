/**
 * Problem Link : https://leetcode.com/problems/next-greater-element-ii/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=2*n-1;i>=0;i--){
          while(!st.isEmpty() && st.peek()<=nums[i%n]){
            st.pop();
          }
          if(i<n){
            ans[i]=st.isEmpty()?-1:st.peek();
          }
          st.push(nums[i%n]);
        }
        return ans;
    }
}
