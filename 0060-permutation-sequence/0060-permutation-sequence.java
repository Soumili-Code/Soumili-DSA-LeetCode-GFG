class Solution {
    public String getPermutation(int n, int k) {
      String ans="";
        List<Integer> nums = new ArrayList<>();
        int fact=1;
        k=k-1;
        for(int i=1;i<n;i++){
          fact=fact*i;
          nums.add(i);
        }
        nums.add(n);
        while(true){
          ans =  ans + String.valueOf(nums.get(k/fact));
          nums.remove(nums.get(k/fact));//for each iteration removing from nums 
          if(nums.size()==0){
            return ans;
          }
          k=k%fact;
          fact=fact/nums.size();
        }

    }
}