/**
 * Problem Link : https://leetcode.com/problems/sum-of-subarray-minimums/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Solution {
  public int sumSubarrayMins(int[] arr) {
    long total = 0;
    int[] nseIndex = findNextSmallerElement(arr);
    int[] pseeIndex = findPreviousSmallerOrEqualElement(arr);
    int MOD = (int) 1e9 + 7;
    for (int i = 0; i < arr.length; i++) {
      long right = nseIndex[i] - i;
      long left =   i-pseeIndex[i];
      long count = (left*right) % MOD;
      total = (total + ((count * arr[i]) % MOD)) % MOD;
    }
    return (int)total;
  }

  private int[] findNextSmallerElement(int[] arr) {
    int[] nseIndex = new int[arr.length];
    Deque<Integer> st = new ArrayDeque<>(); //monotonic stack
    for (int i = arr.length-1; i >= 0; i--) {
      while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
        st.pop();
      }
      nseIndex[i] = st.isEmpty() ? arr.length : st.peek();
      st.push(i);
    }
    return nseIndex;
  }

  private int[] findPreviousSmallerOrEqualElement(int[] arr) {
    int[] pseeIndex = new int[arr.length];
    Deque<Integer> st = new ArrayDeque<>(); //monotonic stack
    for (int i = 0; i < arr.length; i++) {
      while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
        st.pop();
      }
      pseeIndex[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return pseeIndex;
  }
}
