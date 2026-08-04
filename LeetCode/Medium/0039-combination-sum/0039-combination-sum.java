class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ds = new ArrayList<>();//use set if only once number neeed to store
    rec(0, target, ds, candidates, ans);
    return ans;
  }

  private void rec(int idx, int target, List<Integer> ds, int[] arr, List<List<Integer>> ans) {
    if (idx == arr.length) {
      if (target == 0) {
        ans.add(new ArrayList<>(ds));
      }
      return;
    }
    if (arr[idx] <= target) {
      ds.add(arr[idx]);
      rec(idx, target - arr[idx], ds, arr, ans);
      ds.remove(ds.size() - 1);
    }
    rec(idx + 1, target, ds, arr, ans);

  }
}