class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ds = new ArrayList<>();
    Arrays.sort(candidates);
    rec(0, target, ds, candidates, ans);
    return ans;

  }

  private void rec(int idx, int target, List<Integer> ds, int[] arr, List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(new ArrayList<>(ds));
      return;
    }
    for (int i = idx; i < arr.length; i++) {
      if (arr[i] > target)
        break;
      if (i > idx && arr[i] == arr[i - 1]) {
        continue;
      }
      ds.add(arr[i]);
      rec(i + 1, target - arr[i], ds, arr, ans);
      ds.remove(ds.size() - 1);
    }

  }
}