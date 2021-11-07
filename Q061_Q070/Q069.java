package HeadForOffer_II.Q061_Q070;

public class Q069 {

    // 根据 arr[i] > arr[i+1] 在 [0,n-2] 范围内找值
    // 峰顶元素为符合条件的最靠近中心的元素值
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 2;
        while (l <= r) {
            // 除以2相当于向右移动1位
            int mid = l + r >> 1;
            if (arr[mid] > arr[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
