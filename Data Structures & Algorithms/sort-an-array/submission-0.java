class Solution {

    public int[] sortArray(int[] nums) {
        
        int[] temp = new int[nums.length];
        
        mergeSort(nums, temp, 0, nums.length - 1);
        
        return nums;
    }

    public void mergeSort(int[] nums, int[] temp, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(nums, temp, low, mid);
        mergeSort(nums, temp, mid + 1, high);

        merge(nums, temp, low, mid, high);
    }

    public void merge(int[] nums, int[] temp, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy back to nums
        for (int x = low; x <= high; x++) {
            nums[x] = temp[x];
        }
    }
}