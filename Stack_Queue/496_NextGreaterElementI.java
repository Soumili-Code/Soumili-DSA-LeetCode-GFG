/**
 * Problem Link : https://leetcode.com/problems/next-greater-element-i/
 * Platform     : LeetCode
 * Difficulty   : Easy
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> nextGreater = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
          while(!st.isEmpty() && nums2[i]>=st.peek()){
            st.pop();
          }
          if(st.isEmpty()){
            nextGreater.put(nums2[i],-1);
          }
          else{
            nextGreater.put(nums2[i],st.peek());
          }
          st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
          ans[i]=nextGreater.get(nums1[i]);
        }
        return ans;
    }
}
