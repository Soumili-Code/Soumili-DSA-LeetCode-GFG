/**
 * Problem Link : https://leetcode.com/problems/min-stack/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

class Pair {
  int value;
  int minValue = Integer.MAX_VALUE;

  Pair(int v, int min) {
    value = v;
    minValue = min;
  }
}

class MinStack {

  Deque<Pair> st;

  public MinStack() {
    st = new ArrayDeque<>();
  }

  public void push(int value) {
    int currentMin = value;
    if (!st.isEmpty() && st.peek().minValue < currentMin ) {
      currentMin = st.peek().minValue;

    }
    st.push(new Pair(value, currentMin));
  }

  public void pop() {
    st.pop();

  }

  public int top() {
    return st.peek().value;
  }

  public int getMin() {
    return st.peek().minValue;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
