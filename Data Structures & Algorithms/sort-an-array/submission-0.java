class Solution {
    public int[] sortArray(int[] nums) {
        //Tc:O(nlogn) SC: O(1) -> Quick sort
        int low = 0,high = nums.length-1;
        return quickSort(nums,low,high);
    }
    public int[] quickSort(int[] nums,int low,int high){
        if(low<high){
            int partition = findPartitionIndex(nums,low,high);
            nums = quickSort(nums,low,partition-1);
            nums  = quickSort(nums,partition+1,high);
        }
        return nums;
    }
    public int findPartitionIndex(int[] nums,int low,int high){
        int pivot = low;
        int i= low;
        int j= high;
        while(i<j){
            while(i<=high && nums[i]<=nums[pivot] ){
                i++;
            }
            while(j>=low && nums[j]>nums[pivot] ){
                j--;
            }
            if(i<j){
                //swap nums[i] & nums[j]
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }

        }
        //if j<i swap nums[pivot] & nums[j]
        int temp = nums[pivot];
        nums[pivot]=nums[j];
        nums[j]=temp;
        return j;

    }
}