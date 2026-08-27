/**
 * Problem Link : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Platform     : LeetCode
 * Difficulty   : Hard
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int totalArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        // int[] nse = findNextSmallerElement(heights,n);
        // int[] pse = findPrevSmallerElement(height,n);
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                totalArea = Math.max(totalArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int element = st.peek();
            st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            totalArea = Math.max(totalArea, heights[element] * (nse - pse - 1));
        }

        return totalArea;
    }
}

