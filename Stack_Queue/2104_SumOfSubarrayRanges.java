/**
 * Problem Link : https://leetcode.com/problems/sum-of-subarray-ranges/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
  public long subArrayRanges(int[] nums) {
    int n = nums.length;
    long smallest = evaluateLargestOrSmallest(prevSmallerElement(nums,n),nextSmallerElement(nums,n),nums);
    long largest = evaluateLargestOrSmallest(prevGreaterElement(nums,n),nextGreaterElement(nums,n),nums);
    return largest - smallest;

  }
  private long evaluateLargestOrSmallest(int[] prev,int[] next,int[] nums){
    long total=0;
    for(int i=0;i<nums.length;i++){
      int right = next[i]-i;
      int left = i-prev[i];
      long count =(long) left*right*nums[i];
      total+=count;
    }
    return total;
  }

  private int[] nextGreaterElement(int[] nums, int n) {
    int[] nge = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
        st.pop();
      }
      nge[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    return nge;
  }

  private int[] prevGreaterElement(int[] nums,int n) {
    int[] pgee = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
    for (int i = 0; i <= n - 1; i++) {
      while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
        st.pop();
      }
      pgee[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return pgee;

  }

  private int[] nextSmallerElement(int[] nums,int n) {
    int[] nse = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
        st.pop();
      }
      nse[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    return nse;

  }

  private int[] prevSmallerElement(int[] nums,int n) {
    int[] psee = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
    for (int i = 0; i <= n - 1; i++) {
      while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
        st.pop();
      }
      psee[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return psee;

  }
}
