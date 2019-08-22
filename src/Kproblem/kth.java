package Kproblem;

public class kth {
    //k个最大值
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0 || k>nums.length) return -1;
        int n = nums.length-k;
        int l = 0, r= nums.length-1;
        while(l < r){
            int index = partition(nums,l,r);
            if(index == n) return nums[n];
            if(index > n) r = index - 1;
            else l = index + 1;
        }
        return nums[n];
    }
    public int partition(int[] arr,int l,int r){
        int k = arr[l];
        while(l < r){
            while(l < r && arr[r] >= k) r--;
            arr[l] = arr[r];
            while(l < r && arr[l] <= k) l++;
            arr[r] = arr[l];
        }
        arr[l] = k;
        return l;
    }
}
